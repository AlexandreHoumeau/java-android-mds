package fr.mds.demoproject.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import fr.mds.demoproject.R;
import fr.mds.demoproject.model.Virus;

public class VirusListAdapter extends ArrayAdapter<Virus> {

    public VirusListAdapter(@NonNull Context context, @NonNull List<Virus> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Virus v = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_virus_spinner, parent, false);
        }

        TextView tv_item_name = convertView.findViewById(R.id.tv_item_virus_name);
        TextView tv_item_rate = convertView.findViewById(R.id.tv_item_virus_rate);
        TextView tv_item_virus_country = convertView.findViewById(R.id.tv_item_virus_country);

        tv_item_name.setText(v.getName());
        tv_item_rate.setText(v.getMortalityRate() + "%");
        tv_item_virus_country.setText(v.getCountryOrigin());

        return convertView;

    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position, convertView, parent);
    }
}
