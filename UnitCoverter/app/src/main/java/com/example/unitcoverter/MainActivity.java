package com.example.unitcoverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.unitcoverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        Conversion conversion = new Conversion("", getString(R.string.f_to_c), getString(R.string.convert_c));
        binding.setConversion(conversion);


        Spinner conversionType = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.conversion_type,
                        android.R.layout.simple_spinner_dropdown_item);
        conversionType.setAdapter(adapter);

        conversionType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String type = (String) parent.getItemAtPosition(position);
                Log.i("TYPE", type);

                switch (type){
                    case "ºF to ºC":
                        conversion.conversionLabel.setValue(getString(R.string.f_to_c));
                        conversion.type.setValue(getString(R.string.convert_c));
                        break;
                    case "Lbs to Kg":
                        conversion.conversionLabel.setValue(getString(R.string.lbs_to_kg));
                        conversion.type.setValue(getString(R.string.convert_kg));
                        break;
                    case "Mile to Km":
                        conversion.conversionLabel.setValue(getString(R.string.mile_to_km));
                        conversion.type.setValue(getString(R.string.convert_km));
                        break;
                    case "Ft to Meter":
                        conversion.conversionLabel.setValue(getString(R.string.ft_to_meter));
                        conversion.type.setValue(getString(R.string.convert_meter));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button fbtn = findViewById(R.id.convert_btn);
        EditText finput = findViewById(R.id.fahrenheit_input);
        TextView ctxt = findViewById(R.id.celcius_text);



        fbtn.setOnClickListener(v -> {

            TextView label = findViewById(R.id.conversion_label);
            String type = label.getText().toString();

            if (finput.getText().length() == 0)
                return;
            float unitToBeConverted = Float.parseFloat(finput.getText().toString());

            switch (type){
                case "Fahrenheit to Celsius":
                    double celcius = Converter.toCelcius(unitToBeConverted);
                    ctxt.setText(String.format("%.2f ºF is %.2f ºC",unitToBeConverted, celcius));
                    break;
                case "Pound to Kilogram":
                    double kg = Converter.lbsToKg(unitToBeConverted);
                    ctxt.setText(String.format("%.2f lbs is %.2f kg",unitToBeConverted, kg));
                    break;
                case "Mile to Kilometer":
                    double km = Converter.mileToKm(unitToBeConverted);
                    ctxt.setText(String.format("%.2f miles is %.2f km",unitToBeConverted, km));
                    break;
                case "Feet to Meter":
                    double meter = Converter.feetToMeter(unitToBeConverted);
                    ctxt.setText(String.format("%.2f ft is %.2f meters",unitToBeConverted, meter));
                    break;
                default:
                    ctxt.setText("No conversion chosen");
            }

        });
    }
}