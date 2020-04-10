package fr.mds.geekquote.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import fr.mds.geekquote.R;
import fr.mds.geekquote.adapter.QuoteListAdapter;
import fr.mds.geekquote.model.Quote;

public class MainActivity extends Activity  {

    public static final String TAG = "GeekQuote";
    private ArrayList<Quote> quoteList = new ArrayList<Quote>();
    private EditText et_main_quote;
    private Button bt_main_add, bt_signout;
    private LinearLayout ll_list_quotes;
    private ListView lv_main_list;
    private QuoteListAdapter quoteListAdapter;
    private TextView rating;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private Gson gson = new Gson();
    private Object ArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get Quotes from file
        try {
            String content = readFromFile();
            Log.d(TAG, content);
            ArrayList<Quote> savedQuotes = gson.fromJson(content, new TypeToken<List<Quote>>(){}.getType());
            quoteList.addAll(savedQuotes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // FindViewByID
        et_main_quote = findViewById(R.id.et_main_quote);
        bt_main_add = findViewById(R.id.bt_main_add);
        ll_list_quotes = (LinearLayout)findViewById(R.id.list_item);
        lv_main_list = findViewById(R.id.lv_main_list);
        rating = findViewById(R.id.rating);
        bt_signout = findViewById(R.id.bt_signout);

        quoteListAdapter = new QuoteListAdapter(this, quoteList);
        lv_main_list.setAdapter(quoteListAdapter);

        prefs = getSharedPreferences("fr.mds.geekquote", this.MODE_PRIVATE);
        editor = prefs.edit();

        lv_main_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object listItem = lv_main_list.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, QuoteActivity.class);
                intent.putExtra("data", (Serializable) listItem);
                startActivityForResult(intent, 0);
            }
        });

        bt_main_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    addQuotes(et_main_quote.getText().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bt_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("isLogged", false);
                editor.apply();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    protected void addQuotes(String quote) throws IOException {
        quoteList.add(0,new Quote(quote));
        quoteListAdapter.notifyDataSetChanged();
        et_main_quote.getText().clear();
    }


    @Override
    protected void onStop() {
        super.onStop();
        try {
            writeToFile(quoteList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    void writeToFile(ArrayList<Quote> quote) throws IOException {

        String value = gson.toJson(quote);
        Log.d(TAG, value);
        File path = this.getFilesDir();
        File file = new File(path, "quote.txt");

        FileOutputStream stream = new FileOutputStream(file, false);

        try {
            stream.write(value.getBytes());
        } finally {
            stream.close();
        }
    }

    String readFromFile() throws IOException {
        File path = this.getFilesDir();
        File file = new File(path, "quote.txt");

        long length = file.length();
            byte[] bytes = new byte[(int)length];

        FileInputStream in = new FileInputStream(file);

        try {
            in.read(bytes);
        } finally {
            in.close();
        }
        return new String(bytes);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList("quotes", quoteList);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        ArrayList<Quote> retrivedQuotes = savedInstanceState.getParcelableArrayList("quotes");

        quoteList.clear();
        quoteList.addAll(retrivedQuotes);
        quoteListAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (data != null && data.getExtras() != null) {
            String strQuote = data.getExtras().getString("strQuote");
            Float rating = data.getExtras().getFloat("rating");

            for(int i=0 ; i<quoteListAdapter.getCount() ; i++){
                Quote quote = quoteListAdapter.getItem(i);
                if (quote.getStrQuote().equals(strQuote)) {
                    quote.setRating(rating);
                    quoteListAdapter.notifyDataSetChanged();
                }
            }
        }
    }
}
