package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Requirement extends AppCompatActivity {

    EditText firstName, lastName, email,mobile,city,comment;
    Button registerbtn;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requirement);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        db = FirebaseFirestore.getInstance();
        firstName = findViewById(R.id.editTextTextPersonName2);
        lastName = findViewById(R.id.editTextTextPersonName3);
        email = findViewById(R.id.editTextTextPersonName4);
        mobile = findViewById(R.id.editTextTextPersonName5);
        city = findViewById(R.id.editTextTextPersonName6);
        comment = findViewById(R.id.editTextTextPersonName7);
        registerbtn = findViewById(R.id.button);
/*        button2 = findViewById(R.id.button2);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Requirement.this, AddData.class);
                startActivity(intent);
            }
        });*/

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Firstname = firstName.getText().toString();
                String Lastname = lastName.getText().toString();
                String Email = email.getText().toString();
                String Mobile = mobile.getText().toString();
                String City = city.getText().toString();
                String Comment = comment.getText().toString();
                Map<String,Object> user = new HashMap<>();
                user.put("First Name",Firstname);
                user.put("Last Name",Lastname);
                user.put("Age",Email);
                user.put("Mobile",Mobile);
                user.put("City",City);
                user.put("Comment",Comment);


                db.collection("user")
                        .add(user)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(Requirement.this,"Successful",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(Requirement.this,"Failed",Toast.LENGTH_SHORT).show();


                    }
                });

            }
        });

    }
}