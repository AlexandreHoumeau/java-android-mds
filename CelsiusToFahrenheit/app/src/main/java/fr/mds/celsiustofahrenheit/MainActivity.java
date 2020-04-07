package fr.mds.celsiustofahrenheit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "CelsiusToFahrenheit";
    private EditText et_celsius;
    private TextView tv_fahrenheit_result;
    private Button bt_show_result;
    private float result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_celsius = findViewById(R.id.et_celsius);
        tv_fahrenheit_result = findViewById(R.id.tv_fahrenheit_result);
        bt_show_result = findViewById(R.id.bt_show_result);

        bt_show_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    result = Float.parseFloat(et_celsius.getText().toString()) * 9 / 5 + 32;
                    tv_fahrenheit_result.setText(result + "F°");
                } catch (NumberFormatException e) {
                    tv_fahrenheit_result.setText("Is not a number");
                    return;
                }
            }
        });
    }
}
