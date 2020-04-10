package fr.mds.geekquote.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.mds.geekquote.R;
import fr.mds.geekquote.adapter.QuoteListAdapter;
import fr.mds.geekquote.model.Quote;

public class MainActivity extends Activity  {

    public static final String TAG = "GeekQuote";
    private ArrayList<Quote> quoteList = new ArrayList<Quote>();
    private EditText et_main_quote;
    private Button bt_main_add;
    private LinearLayout ll_list_quotes;
    private ListView lv_main_list;
    private QuoteListAdapter quoteListAdapter;
    private TextView rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_main_quote = findViewById(R.id.et_main_quote);
        bt_main_add = findViewById(R.id.bt_main_add);
        ll_list_quotes = (LinearLayout)findViewById(R.id.list_item);
        lv_main_list = findViewById(R.id.lv_main_list);
        rating = findViewById(R.id.rating);

        quoteListAdapter = new QuoteListAdapter(this, quoteList);
        lv_main_list.setAdapter(quoteListAdapter);


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
                addQuotes(et_main_quote.getText().toString());
            }
        });
    }

    protected void addQuotes(String quote) {
        quoteList.add(0,new Quote(quote));
        quoteListAdapter.notifyDataSetChanged();
        et_main_quote.getText().clear();
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
                    Log.d(TAG, quote.getStrQuote() + " - " + strQuote);
                    quote.setRating(rating);
                    quoteListAdapter.notifyDataSetChanged();
                }
            }
        }
    }
}
