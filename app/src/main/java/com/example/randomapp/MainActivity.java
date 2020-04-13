package com.example.randomapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button addBtn,minusBtn,multiplyBtn,divideBtn,powerBtn,clearBtn,equalToBtn, KmToMiBtn;
    EditText  secondNumEditText;
    Float num1,num2;

    boolean clickAdd, clickMinus,clickMultiply, clickPower, clickDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         addBtn = findViewById(R.id.addBtn);
         minusBtn = findViewById(R.id.minusBtn);
         multiplyBtn = findViewById(R.id.multiplyBtn);
         divideBtn = findViewById(R.id.divideBtn);
         powerBtn = findViewById(R.id.powerBtn);
         clearBtn = findViewById(R.id.clearBtn);
         equalToBtn = findViewById(R.id.equalToBtn);
         KmToMiBtn = findViewById(R.id.KmToMiBtn);


        secondNumEditText = findViewById(R.id.secondNumEditText);

        // adding button listener

        //addition button

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (secondNumEditText == null){
                    secondNumEditText.setText("");
                } else {
                    num1 = Float.parseFloat(secondNumEditText.getText() + "");
                    clickAdd = true;
                    secondNumEditText.setText(null);
                }

            }
        });

        //minus button

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Float.parseFloat(secondNumEditText.getText() + "");
                clickMinus = true;
                secondNumEditText.setText(null);

            }
        });

        //division button

        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Float.parseFloat(secondNumEditText.getText() + "");
                clickDivision = true;
                secondNumEditText.setText(null);
            }
        });

        // multiplication button

        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Float.parseFloat(secondNumEditText.getText() + "");
                clickMultiply = true;
                secondNumEditText.setText(null);
            }
        });
        // power button

        powerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Float.parseFloat(secondNumEditText.getText() + "");
                clickPower = true;
                secondNumEditText.setText(null);

            }
        });

        // clear button

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondNumEditText.setText("");
            }
        });

        // equal to button

        equalToBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num2 = Float.parseFloat(secondNumEditText.getText() + "");

                // logic for the signs (+,-,/,ˆˆ*)

                if (clickAdd == true){
                    secondNumEditText.setText(num1 + num2 + "");
                    clickAdd = false;
                }

                if (clickMinus == true){
                    secondNumEditText.setText(num1 - num2 + "");
                    clickMinus = false;
                }

                if (clickMultiply == true){
                    secondNumEditText.setText(num1 * num2 + "");
                    clickMultiply = false;
                }

                if (clickDivision == true){
                    secondNumEditText.setText(num1 / num2 + "");
                    clickDivision = false;
                }

                if (clickPower == true){
                    secondNumEditText.setText(Math.pow(num1,num2) + "");
                    clickPower = false;
                }
            }
        });

        // Activity switch button with listener

        KmToMiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConverter();

            }
        });
    }

    public void openConverter(){

        Intent intentOne = new Intent(MainActivity.this, KilometerToMileActivity.class);
        startActivity(intentOne);
    }
}


