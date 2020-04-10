package fr.mds.geekquote.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import fr.mds.geekquote.R;

public class LoginActivity extends Activity implements View.OnClickListener {

    private EditText et_login_email, et_login_password;
    private Button bt_login_submit;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        prefs = getSharedPreferences("fr.mds.geekquote", this.MODE_PRIVATE);
        editor = prefs.edit();
        if (!prefs.contains("isLogged")) {
            editor.putBoolean("isLogged", false);
            editor.apply();
        } else {
            if (prefs.getBoolean("isLogged", false) == true) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }

        et_login_email = findViewById(R.id.et_login_email);
        et_login_password = findViewById(R.id.et_login_password);
        bt_login_submit = findViewById(R.id.bt_login_submit);

        bt_login_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String email = et_login_email.getText().toString();
        String password = et_login_password.getText().toString();
        if (email.equals("Admin")  && password.equals("Admin")) {
            editor.putBoolean("isLogged", true);
            editor.apply();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
