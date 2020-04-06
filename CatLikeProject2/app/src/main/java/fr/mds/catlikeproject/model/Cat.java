package fr.mds.catlikeproject.model;

import android.util.Log;

import fr.mds.catlikeproject.MainActivity;

public class Cat extends Catlike {

    private String CatFoodBrand;

    public Cat() {
    }

    public Cat(String catFoodBrand) {
        CatFoodBrand = catFoodBrand;
    }

    public Cat(String color, String height, String catFoodBrand) {
        super(color, height);
        CatFoodBrand = catFoodBrand;
    }

    public void setCatFoodBrand(String catFoodBrand) {
        CatFoodBrand = catFoodBrand;
    }

    public String getCatFoodBrand() {
        return CatFoodBrand;
    }

    @Override
    protected void eat() {
        Log.d(MainActivity.TAG, "Eating like a cat");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "CatFoodBrand='" + CatFoodBrand + '\'' +
                '}';
    }
}
