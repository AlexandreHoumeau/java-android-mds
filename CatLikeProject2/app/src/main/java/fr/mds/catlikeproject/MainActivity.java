package fr.mds.catlikeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.mds.catlikeproject.model.Cat;
import fr.mds.catlikeproject.model.Catlike;
import fr.mds.catlikeproject.model.Tiger;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "CatLikeProject";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Main Activity - onCreate");

        //<Generic>
        ArrayList<Integer> myIntList = new ArrayList<>();
        myIntList.add(10);
        Catlike Catlike1 = new Catlike();

        ArrayList<Catlike> catLikes = new ArrayList<>();
        catLikes.add(new Cat());
        catLikes.add(new Catlike());
        catLikes.add(new Tiger());

        for (Catlike c : catLikes) {
            Log.d(TAG, c.toString());
        }

        //Polymorphism
        Catlike myCatlike = new Cat("Royal Canin");
        String color = myCatlike.getColor();

        //Cast
        Cat myCat = (Cat) myCatlike;
        myCat.getCatFoodBrand();

        ArrayList<Catlike> catlike2 = new ArrayList<>();
        catlike2.add(new Cat("Royal Canin"));
        catlike2.add(new Cat("Hill's"));
        catlike2.add(new Catlike());
        catlike2.add(new Tiger());

        for (Catlike c: catlike2) {

            if (c instanceof Cat) {
                Log.d(MainActivity.TAG, "This is a Cat");
            } else if (c instanceof Tiger) {
                Log.d(MainActivity.TAG, "This is a Tiger");
            } else {
                Log.d(MainActivity.TAG, "This is a Catlike");
            }
        }
        Catlike myRandomCatLike = getRandomCatLike();

        if (myRandomCatLike instanceof Cat) {
            Log.d(MainActivity.TAG, "I Got a Cat");
            Cat myCat2 = (Cat)myRandomCatLike;
            myCat2.getCatFoodBrand();
            //((Cat) myRandomCatLike).getCatFoodBrand();
        } else if (myRandomCatLike instanceof Tiger) {
            Log.d(MainActivity.TAG, "I got a tiger");
        } else {
            Log.d(MainActivity.TAG, "I Go a catlike");
        }
    }

    Catlike getRandomCatLike() {
        int randomInt = new Random().nextInt(3);

        if (randomInt == 0) {
            return new Catlike();
        } else if (randomInt == 1) {
            return new Cat();
        } else {
            return new Tiger();
        }

    }
}
