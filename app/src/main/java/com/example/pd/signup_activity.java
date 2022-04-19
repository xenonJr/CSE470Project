package com.example.pd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.HashMap;
import java.util.Map;

public class signup_activity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private FirebaseAuth me;
    private EditText upmail,up_pass,name,number;
    private Button up,back;
    private ProgressBar p;
    private Spinner bg,jela,upojela,gender;
    final String[] blood = {""};
    final String[] jela2 = {""};
    final String[] upojela2 = {""};
    final String[] gender2 = {""};
    DatabaseReference databaseReference;
    FirebaseFirestore firebaseFirestore;
    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        upmail = findViewById(R.id.upmail);
        up_pass = findViewById(R.id.uppass);
        name = findViewById(R.id.name);
        back = findViewById(R.id.back_button_signup);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup_activity.this,Auth.class);
                startActivity(intent);
            }
        });
        jela=findViewById(R.id.jela);
        upojela = findViewById(R.id.upojela);
        upojela.setVisibility(View.INVISIBLE);
        number = findViewById(R.id.number);
        gender = findViewById(R.id.gender);
        up = findViewById(R.id.signuptest);
        up.setOnClickListener(this);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        bg = findViewById(R.id.bg);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.blood_group, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       bg.setAdapter(adapter);
       bg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               blood[0] = parent.getItemAtPosition(position).toString();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

        ArrayAdapter<CharSequence> adapterGen = ArrayAdapter.createFromResource(this,
                R.array.gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapterGen);
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gender2[0] = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> adapterJela = ArrayAdapter.createFromResource(this,
                R.array.jela, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jela.setAdapter(adapterJela);
        jela.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                jela2[0] = parent.getItemAtPosition(position).toString();
                if(jela2[0].equals("Dhaka")){ showDhaka(); }
                if(jela2[0].equals("CTG")){ showCtg(); }
                if(jela2[0].equals("KHULNA")){ showKhul(); }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void showKhul() {
        upojela.setVisibility(View.VISIBLE);
        ArrayAdapter<CharSequence> adapterU = ArrayAdapter.createFromResource(this,
                R.array.Ukhul, android.R.layout.simple_spinner_item);
        adapterU.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        upojela.setAdapter(adapterU);
        upojela.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                upojela2[0] = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void showCtg() {
        upojela.setVisibility(View.VISIBLE);
        ArrayAdapter<CharSequence> adapterU = ArrayAdapter.createFromResource(this,
                R.array.Uctg, android.R.layout.simple_spinner_item);
        adapterU.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        upojela.setAdapter(adapterU);
        upojela.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                upojela2[0] = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.signuptest){
            register();
        }
    }

    private void register() {
        final String mail = upmail.getText().toString();
        final String pass = up_pass.getText().toString();
        final String nameBar = name.getText().toString();
        final String jelaBAr = jela2[0];
        final String Upo = upojela2[0];
        final String phone =number.getText().toString();
        final int p = Integer.parseInt(phone);
        final String genderBar = gender2[0];

        if(nameBar.isEmpty() || jelaBAr.isEmpty() || Upo.isEmpty() || phone.isEmpty() || genderBar.isEmpty()){
            Toast.makeText(signup_activity.this,"COMPLETE ALL DATA",Toast.LENGTH_LONG).show();
            number.requestFocus();
            return;
        }

        if(mail.isEmpty()){
            upmail.setError("Enter mail");
            upmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            upmail.setError("Enter proper mail");
            upmail.requestFocus();
            return;
        }
        if(pass.isEmpty() || pass.length() < 6){
            up_pass.setError("Proper Pass");
            up_pass.requestFocus();
            return;
        }
      //  final Doner doner = new Doner(nameBar,jelaBAr,blood[0],p);
        final Doner Dprofile = new Doner(nameBar, jelaBAr, blood[0], Upo, genderBar,p);

        mAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
              //  p.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    uid = mAuth.getCurrentUser().getUid();
                    DocumentReference documentReference = firebaseFirestore.collection("users").document(uid);
                    documentReference.set(Dprofile).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(),"Succefull",Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext()," Not Succefull"+e,Toast.LENGTH_SHORT).show();
                        }
                    });
                 //   databaseReference.push().setValue(doner);
                    databaseReference.push().setValue(Dprofile);
                  //  Toast.makeText(getApplicationContext(),"Succefull",Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(),"Succefull",Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                   // intent.putExtra(MainActivity.EMAIL,pass);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),"NOt Succefull",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    void showDhaka(){
            upojela.setVisibility(View.VISIBLE);
            ArrayAdapter<CharSequence> adapterU = ArrayAdapter.createFromResource(this,
                    R.array.UDhaka, android.R.layout.simple_spinner_item);
            adapterU.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            upojela.setAdapter(adapterU);
            upojela.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    upojela2[0] = parent.getItemAtPosition(position).toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });



    }
}