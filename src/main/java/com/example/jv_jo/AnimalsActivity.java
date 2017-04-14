package com.example.jv_jo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jv_jo.firstproject.R;

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

        listData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int codPosition = position;

                Bundle animalInformations = new Bundle();
                animalInformations.putString("breedSelected", breedSelected);
                animalInformations.putString("nameAnimal", nameAnimal);
                animalInformations.putString("animalBirth", animalBirth);
                animalInformations.putString("animalWidth", animalLargura);
                animalInformations.putString("animalWeight", animalWeight);
                animalInformations.putString("chefName", nameChef);
                animalInformations.putString("chefCpf", cpfCHEF);
                animalInformations.putString("chefTel", telCHEF);
                animalInformations.putString("animalStreet", animalStreet);
                animalInformations.putString("animalNumberStreet", animalNumberStreet);

                Intent animal = new Intent(AnimalsActivity.this, AnimalActivity.class);
                animal.putExtra("animalDesc", animalInformations);

                startActivity(animal);
            }
        });

        animalItem = nameAnimal + "\n" +
        animalBirth + " " +telCHEF + "\n" +
        nameChef;

        dataAdapter.add(animalItem);
        dataAdapter.notifyDataSetChanged();

    }
}
