package com.example.carloancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    private EditText carCost;
    private EditText downPayment;
    private EditText apr;
    private RadioButton loan;
    private RadioButton lease;
    private EditText calculated;
    private SeekBar loaning;
    private TextView monthNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loan = findViewById(R.id.loan);
        lease = findViewById(R.id.lease);
        carCost = findViewById(R.id.carCost);
        downPayment = findViewById(R.id.downPayment);
        apr = findViewById(R.id.apr);
        loaning = findViewById(R.id.loanlength);
        calculated = findViewById(R.id.calculated);
        monthNumber = findViewById(R.id.monthNumber);

        loaning.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                monthNumber.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }



    public void calculated(View v) {
        //monthly payment = (apr/12)*(carCost-downPayment)/(1-(1+(apr/12))to the negative number of payments)-downPayment
        if (loan.isChecked()) {
            String i = carCost.getText().toString();
            String n = downPayment.getText().toString();
            String p = apr.getText().toString();
            int u = loaning.getProgress();
            double i1= Double.parseDouble(i);
            double p1= Double.parseDouble(p)/100;
            double n1= Double.parseDouble(n);
            double loan = (p1/12)*(i1-n1)/(1-Math.pow(1+(p1/12), -u));
            calculated.setText(String.format("%.1f", +loan));
        }
        else if (lease.isChecked()){
            String i = carCost.getText().toString();
            String n = downPayment.getText().toString();
            String p = apr.getText().toString();
            int u = loaning.getProgress();
            double i1= Double.parseDouble(i);
            double p1= Double.parseDouble(p)/100;
            double n1= Double.parseDouble(n);
            double lease = ((p1/12)*(i1-n1)/(1-Math.pow(1+(p1/12), -u)))/3;
            calculated.setText(String.format("%.1f", +lease));
        }
    }
}
