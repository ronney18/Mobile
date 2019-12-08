package com.example.umlmentor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Mentors extends AppCompatActivity {
    private Button cancelButton;
    private TextView display_data;
    private Button search;
    String mentorName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        display_data = (TextView) findViewById(R.id.searchMentor);
        search = (Button) findViewById(R.id.searchM);


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

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1) {
                   mentorName="Ronney!!";
                } else if (i == 2) {
                    mentorName="Brian!!";
                }else if (i == 3) {
                    mentorName="Danny!!";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display_data.setTextSize(18);
                display_data.setText(mentorName);
            }
        });
    }
}
