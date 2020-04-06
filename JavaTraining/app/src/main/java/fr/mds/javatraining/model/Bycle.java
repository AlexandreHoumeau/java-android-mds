package fr.mds.javatraining.model;

import android.util.Log;

import fr.mds.javatraining.MainActivity;

// JavaBean : encapsulation + default constructor
public class Bycle extends Vehicle{
    private String color;
    private Wheel frontWheel;
    private Wheel backWheel;

    public Bycle() {
    }

    public Bycle(Wheel frontWheel, Wheel backWheel) {
        this.frontWheel = frontWheel;
        this.backWheel = backWheel;
    }

    public Bycle(String color, Wheel frontWheel, Wheel backWheel) {
        this.color = color;
        this.frontWheel = frontWheel;
        this.backWheel = backWheel;
    }

    @Override
    void goForward() {
        Log.d(MainActivity.TAG, "Bycicle go forward");
    }
    public void setFrontWheel(Wheel frontWheel) {
        this.frontWheel = frontWheel;
    }

    public void setBackWheel(Wheel backWheel) {
        this.backWheel = backWheel;
    }

    public Wheel getFrontWheel() {
        return frontWheel;
    }

    public Wheel getBackWheel() {
        return backWheel;
    }

    @Override
    public String toString() {
        return "Bycle{" +
                "color='" + color + '\'' +
                ", frontWheel=" + frontWheel +
                ", backWheel=" + backWheel +
                '}';
    }
}
