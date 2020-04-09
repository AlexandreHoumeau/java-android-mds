package fr.mds.geekquote.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import fr.mds.geekquote.R;
import fr.mds.geekquote.model.Quote;

public class QuoteListAdapter extends ArrayAdapter<Quote> {

    public QuoteListAdapter(@NonNull Context context, @NonNull List<Quote> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Quote q = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_quote_layout, parent, false);
        }

        TextView tv_quote = convertView.findViewById(R.id.tv_quote);
//        RatingBar rb_rating = (RatingBar) convertView.findViewById(R.id.rb_rating);
        TextView tv_creation_date = convertView.findViewById(R.id.tv_creation_date);

        tv_quote.setText(q.getStrQuote());
//        rb_rating.setRating(q.getRating());
        tv_creation_date.setText(java.text.DateFormat.getDateTimeInstance().format(q.getCreationDate()));

        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position, convertView, parent);
    }
}
