package com.example.pd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class searchPlasma extends AppCompatActivity {

    private ListView listView;
    private List<Doner> list;
    private List<Doner> list2;
    DatabaseReference databaseReference;
    private CA custom;
    private Button b,back;
    Spinner bg,jela;
    String[] blood = {""};
    String[] jela2 = {""};
    int c = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_plasma);
        listView = findViewById(R.id.listView);
        b = findViewById(R.id.sea);
        back = findViewById(R.id.back_button_profile);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(searchPlasma.this,MainActivity.class);
                startActivity(intent);
            }
        });
        list = new ArrayList<>();
        list2 = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        custom = new CA(searchPlasma.this,list);

        bg = findViewById(R.id.bloodgrp);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.blood_group, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bg.setAdapter(adapter);
        bg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    blood[0] = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        jela = findViewById(R.id.jelasea);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.jela, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jela.setAdapter(adapter2);
        jela.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                jela2[0] = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            list.clear();
                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                                Doner data = dataSnapshot1.getValue(Doner.class);
                                if(data.bg.equals(blood[0]) && data.jela.equals(jela2[0])){
                                     list2.add(data);
                                     list.add(data);
                                   //  c++;
                              }
                            }
                            listView.setAdapter(custom);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
//                    if(c==0){
//                        Toast.makeText(searchPlasma.this,"No Doner Found",Toast.LENGTH_LONG).show();
//                    }
                }
            });

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(searchPlasma.this,profileDoner.class);
                    intent.putExtra("name",list2.get(position).name);
                    intent.putExtra("Division",list2.get(position).jela);
                    intent.putExtra("District",list2.get(position).upojela);
                    intent.putExtra("gen",list2.get(position).gender);
                    intent.putExtra("bg",list2.get(position).bg);
                    String n = String.valueOf(list2.get(position).number);
                    intent.putExtra("phn",n);
                    startActivity(intent);
                }
            });



    }
}