package fr.mds.demoproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import fr.mds.demoproject.R;

public class PicassoActivity extends Activity {

    private ImageView iv_picasso_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);

        iv_picasso_content = findViewById(R.id.iv_picasso_main_content);

        Picasso.get().load("https://cdn.futura-sciences.com/buildsv6/images/largeoriginal/9/f/b/9fb7262e38_50154418_3-dims.jpg").into(iv_picasso_content);

    }
}
