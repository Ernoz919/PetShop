package com.example.jv_jo.firstproject;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class AnimalsActivity extends Activity {

    String nameAnimal;
    String animalBirth;
    String animalWeight;
    String animalLargura;
    String nameChef;
    String animalStreet;
    String animalNumberStreet;
    String cpfCHEF;
    String telCHEF;
    String arrayData[];
    String animalItem;
    String breedSelected;

    ArrayAdapter<String> adapterData;

    ListView listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        listData = (ListView) findViewById(R.id.listData);
        ArrayList<String> dataArray = new ArrayList<String>();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                dataArray);
        listData.setAdapter(dataAdapter);

        Bundle data = getIntent().getExtras();
        nameAnimal = data.getString("nameAnimal");
        animalBirth = data.getString("animalBirth");
        animalWeight = data.getString("animalWeight");
        animalLargura = data.getString("animalLargura");
        nameChef = data.getString("nameChef");
        animalStreet = data.getString("animalStreet");
        animalNumberStreet = data.getString("animalNumberStreet");
        cpfCHEF = data.getString("cpfCHEF");
        telCHEF = data.getString("telCHEF");
        breedSelected = data.getString("selectedBreed");

        animalItem = breedSelected + " " + nameAnimal + "\n" +
        animalBirth + " " +telCHEF + "\n" +
        nameChef;

        dataAdapter.add(animalItem);
        dataAdapter.notifyDataSetChanged();

    }
}
