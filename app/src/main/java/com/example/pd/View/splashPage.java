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

public class splashPage extends AppCompatActivity {
    int SPLASH_TIME = 3000; //This is 3 seconds
    private TextView appname,dev;
    private ImageView applogo,dlogo;
    private Animation topAnim,bottomAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash);
//        applogo = findViewById(R.id.applogo);
//        dlogo = findViewById(R.id.icon);
//        appname = findViewById(R.id.name);
//        dev = findViewById(R.id.dv);
//        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
//        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
//
//        applogo.setAnimation(topAnim);
//        appname.setAnimation(topAnim);
//        dev.setAnimation(bottomAnim);
//        dlogo.setAnimation(bottomAnim);
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                //Do any action here. Now we are moving to next page
//                Intent mySuperIntent = new Intent(splashPage.this, permissionController.class);
//                startActivity(mySuperIntent);
//
//                //This 'finish()' is for exiting the app when back button pressed from Home page which is ActivityHome
//                finish();
//
//            }
//        }, SPLASH_TIME);
    }
}