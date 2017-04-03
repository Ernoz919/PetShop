package com.example.jv_jo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jv_jo.firstproject.R;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

    }

    public void toRegister(View view){
        Intent register = new Intent(this, RegisterActivity.class);
        startActivity(register);
    }

    public void toAnimals(View view) {
        Intent animal = new Intent(this, AnimalsActivity.class);
        startActivity(animal);
    }

}
