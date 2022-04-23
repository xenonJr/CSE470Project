package com.example.pd.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pd.R;
import com.example.pd.View.MainActivity;

public class aboutPage extends AppCompatActivity {

    Button about,share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_this_app);
//        Button back = findViewById(R.id.back_button_about);
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(about.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
//        about = findViewById(R.id.aboutOnu);
//        share = findViewById(R.id.shareAPp);
//        about.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Uri uriUrl = Uri.parse("https://onulab.org/?fbclid=IwAR0Lyvz2mhq9YCIk-gLqca7YgnyXSNoWIbHJhhp6twjSHZ-KW3neebejinE");
//                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
//                startActivity(launchBrowser);
//            }
//        });
//        share.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"Not Available in MVP",Toast.LENGTH_LONG).show();
//            }
//        });
    }
}