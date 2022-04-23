package com.example.pd.Controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pd.R;
import com.example.pd.View.MainActivity;
import com.example.pd.View.signupPage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class authController extends AppCompatActivity {

    private Button signup,login,button;
    private FirebaseAuth mAuth;
    private EditText mail,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signup = findViewById(R.id.signup);
        login = findViewById(R.id.login);
        mail = findViewById(R.id.user_login);
        pass = findViewById(R.id.password_login);
        mAuth = FirebaseAuth.getInstance();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(authController.this, signupPage.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        button = findViewById(R.id.back_button_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(authController.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    private void login() {
        final String Email = mail.getText().toString();
        final String Password = pass.getText().toString();

        if(Email.isEmpty()){
            mail.setError("Enter mail");
            mail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            mail.setError("Enter proper mail");
            mail.requestFocus();
            return;
        }
        if(Password.isEmpty() || Password.length() < 6){
            pass.setError("Proper Pass");
            pass.requestFocus();
            return;
        }


        mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Toast.makeText(authController.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(authController.this, "Not Successfull", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}