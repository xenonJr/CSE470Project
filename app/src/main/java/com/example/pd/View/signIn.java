package com.example.pd.View;


import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pd.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class signIn extends AppCompatActivity  implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private FirebaseAuth me;
    private EditText upmail,up_pass,name,number;
    private Button up,back;
    FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        upmail = findViewById(R.id.upmail);
        up_pass = findViewById(R.id.uppass);
        up = findViewById(R.id.signuptest);
        up.setOnClickListener(this);

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


        mAuth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //  p.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), profileOwn.class);
                    // intent.putExtra(MainActivity.EMAIL,pass);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),"NOt Succefull",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}