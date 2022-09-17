package com.example.sdj2assignment1.radiator;

public interface RadiatorState {
    void turnUp(Radiator radiator);
    void turnDown(Radiator radiator);
    int getPower();
}
