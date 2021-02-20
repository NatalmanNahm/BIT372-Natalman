package com.example.unitcoverter;

import androidx.lifecycle.MutableLiveData;

public class Conversion {

    public MutableLiveData<String> convert;
    public MutableLiveData<String> conversionLabel;
    public MutableLiveData<String> type;

    public Conversion(String convert, String conversionLabel, String type) {
        this.convert = new MutableLiveData<>();
        this.convert.setValue(convert);
        this.conversionLabel = new MutableLiveData<>();
        this.conversionLabel.setValue(conversionLabel);
        this.type = new MutableLiveData<>();
        this.type.setValue(type);
    }
}
