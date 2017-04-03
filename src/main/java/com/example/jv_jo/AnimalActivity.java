package com.example.jv_jo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jv_jo.firstproject.R;

public class AnimalActivity extends Activity {

    TextView descriptionView;
    String desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        Bundle data = getIntent().getExtras();
        desc = data.getString("animalDesc");
        descriptionView = (TextView) findViewById(R.id.animaDescription);
        descriptionView.setText(desc);
    }
}
