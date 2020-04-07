package fr.mds.geekquote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

import fr.mds.geekquote.model.Quote;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "GeekQuote";
    Date myDate = new Date();
    ArrayList<Quote> quotes = new ArrayList<Quote>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources resources = getResources();

        String[] quotesArray = resources.getStringArray(R.array.quote_array);


        for (String c: quotesArray) {
            addQuotes(c.toString());
        }

        for (Quote c : quotes) {
            Log.d(TAG, c.toString());
        }

    }

    protected void addQuotes(String quote) {
        quotes.add(new Quote(quote, 5, myDate));
    }
}
