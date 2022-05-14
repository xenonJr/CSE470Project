package com.example.pd.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pd.Controller.permissionController;
import com.example.pd.R;

import java.util.Calendar;

public class splashPage extends AppCompatActivity {

    private TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        time = findViewById(R.id.name);

        long currTime = System.currentTimeMillis();
        String cTime = Calendar.getInstance().getTime().toString();

        time.setText(cTime);

    }
}