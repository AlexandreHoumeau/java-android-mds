package fr.mds.demoproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fr.mds.demoproject.R;
import fr.mds.demoproject.adapter.VirusListAdapter;
import fr.mds.demoproject.model.ProgramingLanguage;
import fr.mds.demoproject.model.Virus;

public class SpinnerActivity extends Activity
    implements View.OnClickListener {

    private Button bt_main_1, bt_main_2, bt_main_3;
    private Spinner sp_main_select, sp_main_custom_select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_main_1 = findViewById(R.id.bt_main_1);
        bt_main_2 = findViewById(R.id.bt_main_2);
        bt_main_3 = findViewById(R.id.bt_main_3);
        sp_main_select = findViewById(R.id.sp_main_select);
        sp_main_custom_select = findViewById(R.id.main_custom_select);

        bt_main_1.setOnClickListener(this);
        bt_main_2.setOnClickListener(this);
        bt_main_3.setOnClickListener(this);

        ProgramingLanguage[] programingLanguages = {
                new ProgramingLanguage("Java", "Java is life"),
                new ProgramingLanguage("C++", "C++ is evil"),
                new ProgramingLanguage("PHP", "PHP is cool"),
                new ProgramingLanguage("COBOL", "Cobol is old")
        };

        ArrayAdapter arrayAdapter = new ArrayAdapter<ProgramingLanguage>(
          this,
          R.layout.item_spinner,
          programingLanguages
        );
        sp_main_select.setAdapter(arrayAdapter);


        List<Virus> virusList = new ArrayList<>();
        virusList.add(new Virus("Covid-19", "China", 4));
        virusList.add(new Virus("Spanis-Flue", "Spain", 4));
        virusList.add(new Virus("WinVista", "USA", 98));

        VirusListAdapter virusListAdapter = new VirusListAdapter(this, virusList);

        sp_main_custom_select.setAdapter(virusListAdapter);
    }

    @Override
    public void onClick(View v) {


        if (v == bt_main_1) {
            Toast.makeText(this, "Button1 Clicked", Toast.LENGTH_SHORT).show();
        } else if (v == bt_main_2) {
            Object object = sp_main_select.getSelectedItem();
            ProgramingLanguage selectProgramingLanguage = (ProgramingLanguage) object;

            String textToShow =
                    selectProgramingLanguage.getName() +
                            "\n" +
                            selectProgramingLanguage.getDetail();
            Toast.makeText(this, textToShow, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Button3 Clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
