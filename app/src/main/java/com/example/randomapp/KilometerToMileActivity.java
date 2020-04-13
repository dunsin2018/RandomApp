package com.example.randomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KilometerToMileActivity extends AppCompatActivity {

    Button converterBtn, mileToKm;
    EditText inputedKm;
    TextView result;

    double kilometer;
    double kmConst=0.621371;
    double resultInMiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kilometer_to_mile);


        converterBtn=findViewById(R.id.converterBtnKm);
        inputedKm=findViewById(R.id.editTextKilometer);
        result=findViewById(R.id.editTextKmTitle);
        mileToKm=findViewById(R.id.mileToKm);

        converterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kilometer=Double.parseDouble(String.valueOf(inputedKm.getText()));

                resultInMiles=kilometer*kmConst;

                result.setText(String.valueOf(resultInMiles)+ " miles");
            }
        });

        mileToKm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTwo = new Intent(KilometerToMileActivity.this, MileToKilometer.class);
                startActivity(intentTwo);
            }

        });
    }
}
