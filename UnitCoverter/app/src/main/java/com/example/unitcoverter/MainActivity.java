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
            if (finput.getText().length() == 0)
                return;
            int fahrenheit = Integer.parseInt(finput.getText().toString());
            double celcius = Converter.toCelcius(Float.parseFloat(finput.getText().toString()));
            ctxt.setText(String.format("%d ºF is %.2f ºC",fahrenheit, celcius));
        });
    }
}