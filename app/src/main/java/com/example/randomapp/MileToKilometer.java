package com.example.randomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MileToKilometer extends AppCompatActivity {

    TextView textView, textView2, textView3;

    EditText inputedMile;

    Button convertMileBtn;


    double mile;
    double mileConst= 1.60934;
    double resultInKilometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mile_to_kilometer);


        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        inputedMile=findViewById(R.id.inputedMile);
        convertMileBtn=findViewById(R.id.convertMileBtn);



        convertMileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mile=Double.parseDouble(String.valueOf(inputedMile.getText()));

                resultInKilometer=mile*mileConst;
                textView3.setText(String.valueOf(resultInKilometer)+ " Km");


            }
        });
    }
}
