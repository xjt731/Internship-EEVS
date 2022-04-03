package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Contact extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    // Declare a RecyclerView object reference
    RecyclerView recyclerView;
    // Declare an adapter
    RecyclerView.Adapter programAdapter;
    RecyclerView.LayoutManager layoutmanager;
    // Next, prepare your data set. Create two string arrays for program name and program description respectively.
    String[] programNameList = {/*"Safal Sayemi",*/ "Dikchya Dahal", "Jatinder Choudhary", "Rupak Bartaula", "Shishir Gautam", "Hiten Mistry"};
    /*            "jQuery", "Bootstrap", "PHP",
                "MySQL", "CodeIgniter", "React", "NodeJS", "AngularJS", "PostgreSQL", "Python", "C#", "Wordpress", "GitHub"};*/
    String[] programDescriptionList = {"Safal leads the migration division at Expert Education office in Sydney. Having worked as a Registered Migration Agent for eight years, Safal has helped thousands...", "Dikchya came to Australia in 2009 as an international student to study for a Master of Professional Accounting at UTS, Sydney. A decade ago, she...", "Jatinder leads the migration team at Expert Education and Visa Services in Adelaide. Practicing as a Migration Agent for over four years now. He...",
            "Rupak is the General Manager at the Adelaide office as well as being one of our on-site Registered Migration Agents. His skills... ", "Shishir Gautam holds a Graduate Diploma in Migration Law from the University of Technology Sydney and is one of the Registered... ",
            "A Registered Migration Agent with more than 3 years experience in providing migration... ", "Rebecca leads the team at the Expert Education office in Hobart. Born and raised in... ", };
    /*            "jQuery Description",
                "Bootstrap Description", "PHP Description", "MySQL Description",
                "CodeIgniter Description", "React Description", "NodeJS Description",
                "AngularJS Description", "PostgreSQL Description", "Python Description",
                "C# Description", "Wordpress Description", "GitHub Description"};*/
    // Define an integer array to hold the image recourse ids
    int[] programImages = {R.drawable.cplusplus,
            R.drawable.java, R.drawable.android, R.drawable.html5,
            R.drawable.css3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.contact);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),Dashboard.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.contact:
                        return true;


                    case R.id.agent:
                        startActivity(new Intent(getApplicationContext(),Agents.class));
                        overridePendingTransition(0,0);
                        return true;


                }

                return false;
            }
        });

        // Obtain a handle for the RecyclerView
        recyclerView = findViewById(R.id.rwProgram);
        // You may use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // Use a linear layout manager
        layoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutmanager);
        // Create an instance of ProgramAdapter. Pass context and all the array elements to the constructor
        programAdapter = new ProgramAdapterTwo(this, programNameList, programDescriptionList, programImages);
        // Finally, attach the adapter with the RecyclerView
        recyclerView.setAdapter(programAdapter);
    }
}