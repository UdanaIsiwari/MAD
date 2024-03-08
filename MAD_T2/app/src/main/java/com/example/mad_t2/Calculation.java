package com.example.mad_t2;

public class Calculation {
    protected float convertCelciusToFahrenhite(float value){
        float ans = (value * 9/5) + 32 ;
        return ans;
    }
    protected float convertFahrenhiteToCelcius(float value){
        float ans = (value - 32) * 5/9 ;
        return ans;
    }
}
