package com.example.pd.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pd.R;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.List;

public class permissionController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);



        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              ////
                PermissionListener permissionListener = new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        Toast.makeText(permissionController.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionDenied(List<String> deniedPermissions) {
                        Toast.makeText(permissionController.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT)
                                .show();
                    }
                };


                TedPermission.with(getApplicationContext())
                        .setPermissionListener(permissionListener)
                        .setRationaleTitle("R.string.rationale_title")
                        .setRationaleMessage("R.string.rationale_message")
                        .setDeniedTitle("Permission denied")
                        .setDeniedMessage(
                                "If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                        .setGotoSettingButtonText("bla bla")
                        .setPermissions(Manifest.permission.ACCESS_WIFI_STATE,Manifest.permission.INTERNET,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.VIBRATE,Manifest.permission.ACCESS_NETWORK_STATE,Manifest.permission.RECORD_AUDIO,Manifest.permission.MODIFY_AUDIO_SETTINGS,Manifest.permission.READ_PHONE_STATE,
                                Manifest.permission.CAMERA,Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.FOREGROUND_SERVICE)
                        .check();


            }
        });




    }
}