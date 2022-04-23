package com.example.pd.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pd.R;

public class disclimerPage extends AppCompatActivity {

    private Button n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclimer);
        n = findViewById(R.id.np);
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(disclimerPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}