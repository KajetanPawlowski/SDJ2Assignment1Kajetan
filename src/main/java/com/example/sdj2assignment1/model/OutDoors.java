package com.example.sdj2assignment1.model;

public class OutDoors {
    private int UpperLimit =50;
    private int LowerLimit = -30;
    private int latesttemp;

    /**
     * Calculating the external temperature.
     * Values are only valid if the temperature is being measured
     * approximately every 10th second.
     *
     * @param t0 the last measured external temperature
     * @param min a lower limit (may temporally be deceeded)
     * @param max an upper limit (may temporally be exceeded)
     * @return an updated external temperature
     */
    public double externalTemperature(double t0, double min, double max)
    {
        double left = t0 - min;
        double right = max - t0;
        int sign = Math.random() * (left + right) > left ? 1 : -1;
        t0 += sign * Math.random();
        return t0;
    }

}
