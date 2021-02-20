package com.example.unitcoverter;

public class Converter {
    public static float toCelcius(float fah) {
        return (fah - 32) * 5/9;
    }
    public static float lbsToKg(float lbs){
        return (float) (lbs * 0.45359237);
    }
    public static float mileToKm(float mile){
        return (float) (mile/0.62137);
    }
    public static float feetToMeter(float feet){
        return (float) (feet/3.2808);
    }
}
