package com.example.sdj2assignment1.model;

public class SummerHouse {
   // completely forgot what was the purpose of this class
    //was it ViewModel????

    Radiator radiator = new Radiator();
    // near the heater      1 meter from
    Thermometer t1 = new Thermometer(1, radiator);
    //opossite corner      7 meters from
    Thermometer t2 = new Thermometer(7, radiator);


}
