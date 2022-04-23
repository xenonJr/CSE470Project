package com.example.pd.Controller;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class databaseController {
    DatabaseReference databaseReference;

    public DatabaseReference getDatabaseReference() {
        return databaseReference;
    }

    public void setDatabaseReference(DatabaseReference databaseReference) {
        this.databaseReference = databaseReference;
    }

    public void getData(){
        databaseReference = FirebaseDatabase.getInstance().getReference();


    }
}
