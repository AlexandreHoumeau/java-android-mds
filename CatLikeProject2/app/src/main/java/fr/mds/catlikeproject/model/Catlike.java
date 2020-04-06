package fr.mds.catlikeproject.model;

import android.util.Log;

import fr.mds.catlikeproject.MainActivity;

public class Catlike {

    private String color;
    private String height;

    public Catlike() {
    }

    protected void eat() {
        Log.d(MainActivity.TAG, "Catlike is eating");
    }

    public Catlike(String color, String height) {
        this.color = color;
        this.height = height;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public String getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Catlike{" +
                "color='" + color + '\'' +
                ", height='" + height + '\'' +
                '}';
    }
}
