package com.example.unitcoverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fbtn = findViewById(R.id.convert_btn);
        Button kgBtn = findViewById(R.id.convert_to_kg);

        EditText finput = findViewById(R.id.fahrenheit_input);
        EditText lbsEditText = findViewById(R.id.lbs_editText);

        TextView ctxt = findViewById(R.id.celcius_text);
        TextView kgTextView = findViewById(R.id.kg_convert);

        fbtn.setOnClickListener(v -> {
            if (finput.getText().length() == 0)
                return;
            double celcius = Converter.toCelcius(Float.parseFloat(finput.getText().toString()));
            ctxt.setText(String.format("%.2f ºC", celcius));
        });

        kgBtn.setOnClickListener(v -> {
            if (lbsEditText.getText().length() == 0 || lbsEditText.getText().toString().equals("0")) {
                kgTextView.setText("Cannot convert 0 lbs");
            } else {
                double kg = Converter.lbsToKg(Float.parseFloat(lbsEditText.getText().toString()));
                kgTextView.setText(String.format("%.2f Kg", kg));
            }

        });
    }
}