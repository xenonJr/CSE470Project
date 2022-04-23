package com.example.pd.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pd.R;

public class profileDoner extends AppCompatActivity {

    private TextView name,jela,uj,bg,num,gen;
    Button button,call;
    String number = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_doner);
        name = findViewById(R.id.pn);
        jela = findViewById(R.id.pj);
        uj = findViewById(R.id.puj);
        bg = findViewById(R.id.pbg);
        num = findViewById(R.id.pnum);
        gen = findViewById(R.id.pgen);
        call = findViewById(R.id.callbutt);
        button = findViewById(R.id.back_button_profile);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profileDoner.this, MainActivity.class);
                startActivity(intent);
            }
        });
        name.setText(getString(R.string.username)+this.getIntent().getStringExtra("name"));
        jela.setText(getString(R.string.district)+this.getIntent().getStringExtra("Division"));
        uj.setText(getString(R.string.sub_district)+this.getIntent().getStringExtra("District"));
        bg.setText(getString(R.string.blood_group)+this.getIntent().getStringExtra("bg"));
        gen.setText(getString(R.string.gender)+this.getIntent().getStringExtra("gen"));
        num.setText(getString(R.string.number)+this.getIntent().getStringExtra("phn"));
        number =  this.getIntent().getStringExtra("phn");
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    if(Build.VERSION.SDK_INT > 22)
                    {
                        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling

                            ActivityCompat.requestPermissions((Activity) getApplicationContext(), new String[]{Manifest.permission.CALL_PHONE}, 101);

                            return;
                        }

                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:" +"0"+ number));
                        startActivity(callIntent);

                    }
                    else {
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:" +"0"+ number));
                        startActivity(callIntent);
                    }
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });

    }
}