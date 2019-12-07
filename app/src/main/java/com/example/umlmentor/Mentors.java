package com.example.umlmentor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Mentors extends AppCompatActivity {
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);
        cancelButton = (Button) findViewById(R.id.cancelButton);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(Mentors.this, Homepage.class));
            }
        });

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Mentors.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.majors));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

//        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                if (i == 1) {
//                    startActivity(new Intent(Mentors.this, HomeActivity.class));
//                } else if (i == 2) {
//                    startActivity(new Intent(Mentors.this, WorkActivity.class));
//                }else if (i == 3) {
//                    startActivity(new Intent(Mentors.this, OtherActivity.class));
//                }else if (i == 4) {
//                    startActivity(new Intent(Mentors.this, CustomActivity.class));
//                }
//            }

//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
    }
}
