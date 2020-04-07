package fr.mds.geekquote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import fr.mds.geekquote.model.Quote;

public class MainActivity extends AppCompatActivity  {

    public static final String TAG = "GeekQuote";
    private ArrayList<Quote> quotes = new ArrayList<Quote>();
    private EditText et_main_quote;
    private Button bt_main_add;
    private LinearLayout ll_list_quotes;
    private Integer count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_main_quote = findViewById(R.id.et_main_quote);
        bt_main_add = findViewById(R.id.bt_main_add);
        ll_list_quotes = (LinearLayout)findViewById(R.id.list_item);
        

        bt_main_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addQuotes(et_main_quote.getText().toString());
            }
        });


    }

    protected void addQuotes(String quote) {
        count++;
        quotes.add(new Quote(quote));
        Toast.makeText(this, quote, Toast.LENGTH_SHORT).show();
        final TextView rowTextView = new TextView(this);
        ll_list_quotes.addView(rowTextView);
        rowTextView.setText(quote);
        rowTextView.setTextSize(23);
        if (count % 2 == 0) {
            rowTextView.setBackgroundColor(0xFF7947FF);
            rowTextView.setTextColor(0xFFFFFFFF);
        }
    }

}
