package com.example.pd.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pd.Model.Doner;
import com.example.pd.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class profileOwn extends AppCompatActivity {

    DatabaseReference databaseReference;
    FirebaseFirestore firebaseFirestore;
    String uid;
    private FirebaseAuth mAuth;
    private TextView name,jela,uj,bg,num,gen;
    Button button,log,sin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
         name = findViewById(R.id.pn);
         jela = findViewById(R.id.pj);
        uj = findViewById(R.id.puj);
        log = findViewById(R.id.logout);
        sin = findViewById(R.id.sin);
        sin = findViewById(R.id.sin);
        button = findViewById(R.id.back_button_profile);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profileOwn.this, MainActivity.class);
                startActivity(intent);
            }
        });
         bg = findViewById(R.id.pbg);
        num = findViewById(R.id.pnum);
        mAuth = FirebaseAuth.getInstance();
        gen = findViewById(R.id.pgen);
        firebaseFirestore = FirebaseFirestore.getInstance();


        if(mAuth.getCurrentUser() != null){
            log.setVisibility(View.VISIBLE);
            uid = mAuth.getCurrentUser().getUid();
            DocumentReference documentReference = firebaseFirestore.collection("users").document(uid);
             documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                  Doner doner = documentSnapshot.toObject(Doner.class);
                   name.setText(getString(R.string.username)+doner.getName());
                   jela.setText(getString(R.string.district)+doner.getJela());
                   uj.setText(getString(R.string.sub_district)+doner.getUpojela());
                   bg.setText(getString(R.string.blood_group)+doner.getBg());
                   gen.setText(getString(R.string.gender)+doner.getGender());
                   num.setText(getString(R.string.email)+":  "+mAuth.getCurrentUser().getEmail());
            }
        });}else{
            name.setText("    Please Sign Up First");
            name.setTextSize(30);
            name.setGravity(Gravity.CENTER_HORIZONTAL);
            jela.setText("  sign up only if u want to donate plasma");
            uj.setText("");
            bg.setText("");
            gen.setText("");
            num.setText("");
            sin.setVisibility(View.VISIBLE);
            sin.setText("Sign Up");
            sin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(profileOwn.this, signupPage.class);
                    startActivity(intent);
                }
            });
        }


        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profileOwn.this, MainActivity.class);
                startActivity(intent);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.getInstance().signOut();
                finish();
                Intent intent = new Intent(profileOwn.this,signupPage.class);
                startActivity(intent);
            }
        });

    }


}