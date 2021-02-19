package com.example.unitcoverter;

import androidx.lifecycle.MutableLiveData;

public class Conversion {

    public MutableLiveData<String> convert;
    public MutableLiveData<String> conversionLabel;

    public Conversion(String convert, String conversionLabel) {
        this.convert = new MutableLiveData<>();
        this.convert.setValue(convert);
        this.conversionLabel = new MutableLiveData<>();
        this.conversionLabel.setValue(conversionLabel);
    }
}
