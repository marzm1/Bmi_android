package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText waga;
    private EditText wzrost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        waga  = (EditText) findViewById(R.id.txtWaga);
        wzrost = (EditText) findViewById(R.id.txtWzrost);

        Button button1 = (Button) findViewById(R.id.button1);

        TextView Rezultat = (TextView) findViewById(R.id.tvRezultat);

        TextView Bmi = (TextView) findViewById(R.id.tvCosDoIfuw);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                double kg = Double.valueOf(waga.getText().toString());
                double metry = Double.valueOf(wzrost.getText().toString());
                metry = metry/100;
                metry = metry*metry;

                double result = (double)(kg/metry);
                result =  Math.floor(result * 100) / 100;
                String wynikBmi;
                if(result<18.5){
                    wynikBmi = "chudzina mordo";
                }
                else if(result<24.9){
                    wynikBmi = "jest git wariacie";
                }
                else if(result<29.9){
                    wynikBmi="no troszeczke grubasek, idz na bieznie";
                }
                else{
                    wynikBmi="200 pajacyków, 15 basenów i 20 kilometrów dziennie to naprawi";
                }

                Bmi.setText(wynikBmi);

                Rezultat.setText("twoje bmi to: " + result);
            }
        });
    }
}