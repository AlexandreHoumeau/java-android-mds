package fr.mds.javatraining;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.time.Clock;

import fr.mds.javatraining.model.Bycle;
import fr.mds.javatraining.model.Wheel;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "JavaTraining";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Hello World");

        //Create New Instance
        Wheel wheel1 = new Wheel();
        Wheel wheel2 = new Wheel();

        Bycle myBycle1 = new Bycle();
        Bycle myBycle2 = new Bycle();
        Bycle myBicle3 = new Bycle( "pink", wheel1, wheel2);

        Log.d(TAG, "bycicle3" + myBicle3);
    }
}
