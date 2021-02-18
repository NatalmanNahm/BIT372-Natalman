package com.example.unitcoverter;

import androidx.lifecycle.MutableLiveData;

public class Conversion {

    public MutableLiveData<String> convert;

    public Conversion(String convert) {
        this.convert = new MutableLiveData<>();
        this.convert.setValue(convert);
    }
}
