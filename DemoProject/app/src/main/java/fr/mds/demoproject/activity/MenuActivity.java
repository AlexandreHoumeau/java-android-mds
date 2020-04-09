package fr.mds.demoproject.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import fr.mds.demoproject.R;
import fr.mds.demoproject.model.Virus;

public class MenuActivity extends Activity implements View.OnClickListener {
    public static final String TAG = "DemoProject";
    private Button bt_menu_spinner, bt_menu_picasso, bt_menu_extra, bt_menu_open_url;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);

        bt_menu_picasso = findViewById(R.id.bt_menu_picasso);
        bt_menu_spinner = findViewById(R.id.bt_menu_spinner);
        bt_menu_extra = findViewById(R.id.bt_menu_extra);
        bt_menu_open_url = findViewById(R.id.bt_menu_open_url);

        bt_menu_open_url.setOnClickListener(this);
        bt_menu_picasso.setOnClickListener(this);
        bt_menu_spinner.setOnClickListener(this);
        bt_menu_extra.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == bt_menu_spinner) {
            Log.d(TAG, "Menu Activity - OnClick - bt_menu_spinner");

            Intent intent = new Intent(this, SpinnerActivity.class);
            startActivity(intent);
            return;
        } else if (v == bt_menu_picasso) {
            Log.d(TAG, "Menu Activity - OnClick - bt_menu_Picasso");

            Intent intent = new Intent(this, PicassoActivity.class);
            startActivity(intent);
            return;
        } else if (v == bt_menu_extra) {
            Log.d(TAG, "Menu Activity - OnClick - bt_menu_extra");

            Virus virus = new Virus("Covid-19", "China", 2);

            Intent intent = new Intent(this, DemoExtraActivity.class);
            intent.putExtra("message", "This is a message from MenuActivity");
            intent.putExtra("virus",virus);
            startActivityForResult(intent, 0);
            return;
        } else {
            Log.d(TAG, "Menu Activity - OnClick - bt_menu_open_url");

            Uri uri = Uri.parse("https://www.mydigitalschool.com/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
            return;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "MenuActivity - onActivityResult" + resultCode);

        if (data != null && data.getExtras() != null) {
            String response = data.getExtras().getString("response");
            Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
        }
    }
}
