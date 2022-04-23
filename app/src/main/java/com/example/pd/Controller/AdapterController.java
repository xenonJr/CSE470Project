package com.example.pd.Controller;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;

import com.example.pd.Model.Doner;
import com.example.pd.R;

import java.util.List;

public class AdapterController extends ArrayAdapter {
    private  int MY_PERMISSIONS_REQUEST_CALL_PHONE = 0;
    private Activity con;
    private List<Doner> students;


    public AdapterController(Activity context, List<Doner> students) {
        super(context, R.layout.detailslayout, students);
        this.con = context;
        this.students = students;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = con.getLayoutInflater();

        View v = layoutInflater.inflate(R.layout.detailslayout, null, true);

        Doner student = students.get(position);
        TextView t1 =  v.findViewById(R.id.donerName);
        TextView t2 =  v.findViewById(R.id.DonerBlood);
        TextView t3 =  v.findViewById(R.id.NumberDoner);
        Button call = v.findViewById(R.id.callbutt);

        final String name = student.getName();
        String bg = student.getBg();
        final int num = student.getNumber();
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call(num);
            }
        });




        t1.setText("Name: "+name);
        t2.setText("Blood Group: "+bg);
        t3.setText("Number: "+num);

        return v;
    }

    private void call(int num) {
        try
        {
            if(Build.VERSION.SDK_INT > 22)
            {
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling

                    ActivityCompat.requestPermissions((Activity) getContext(), new String[]{Manifest.permission.CALL_PHONE}, 101);

                    return;
                }

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + num));
                con.startActivity(callIntent);

            }
            else {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + num));
                con.startActivity(callIntent);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
