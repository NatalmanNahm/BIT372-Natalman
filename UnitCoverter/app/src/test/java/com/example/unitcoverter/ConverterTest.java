package com.example.unitcoverter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ConverterTest {
    @Test
    public void fahrenheit_conversion_isCorrect() {
        assertEquals(0.0, Converter.toCelcius(32),0.01);
    }

    @Test
    public void test_lbs_to_kg_isCorrect() {
        assertEquals(6.80, Converter.lbsToKg(15),6.81);
    }

    @Test
    public void test_convert_to_km_isCorrect(){
        assertEquals(40.23, Converter.mileToKm(25), 40.24);
    }

    @Test
    public void test_convert_to_meter(){
        assertEquals(16.76, Converter.feetToMeter(55), 16.77);
    }
}