package com.example.pd.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.pd.Controller.authController;
import com.example.pd.R;

public class MainActivity extends AppCompatActivity {

    private Button search,donate;
    ImageView pro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main);

        //initiating views
        search = findViewById(R.id.search);
        donate = findViewById(R.id.donate);
        pro = findViewById(R.id.profile);




        //routing
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, authController.class);
                startActivity(intent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, searchPlasma.class);
                startActivity(intent);
            }
        });
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, splashPage.class);
                startActivity(intent);
            }
        });



    }
}
