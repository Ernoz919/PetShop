package com.example.jv_jo.firstproject;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.drawable.DrawableWrapper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends Activity {

    RadioButton radioDog;
    RadioButton radioCat;
    RadioButton radioBird;

    String arrayDog[];
    String arrayCat[];
    String arrayBird[];
    String arrayList[];
    String arraySelected[];

    String choiceBreed;
    String selectedBreed;

    Button toList;
    Button enter;

    ListView listChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        arrayDog = new String[5];
        arrayDog[0] = "Labrador";
        arrayDog[1] = "Pinscher";
        arrayDog[2] = "Pit bull";
        arrayDog[3] = "Poodle";
        arrayDog[4] = "Outro...";

        arrayCat = new String[5];
        arrayCat[0] = "Himalaia";
        arrayCat[1] = "Persa";
        arrayCat[2] = "Siamês";
        arrayCat[3] = "Sphynx";
        arrayCat[4] = "Outro...";

        arrayBird = new String[5];
        arrayBird[0] = "Canário";
        arrayBird[1] = "Calopsita";
        arrayBird[2] = "Calafete";
        arrayBird[3] = "Cacatua";
        arrayBird[4] = "Outro...";

        arrayList = new String[5];

        arraySelected = new String[5];
        arraySelected[0] = "choiceOne";
        arraySelected[1] = "choiceTwo";
        arraySelected[2] = "choiceThree";
        arraySelected[3] = "choiceFour";
        arraySelected[4] = "choiceFive";

        radioDog = (RadioButton) findViewById(R.id.radioDog);
        radioDog.setOnClickListener(clickDog);
        radioCat = (RadioButton) findViewById(R.id.radioCat);
        radioCat.setOnClickListener(clickCat);
        radioBird = (RadioButton) findViewById(R.id.radioBird);
        radioBird.setOnClickListener(clickBird);

        toList = (Button) findViewById(R.id.animalBreedButton);
        toList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
                View choiceView = getLayoutInflater().inflate(R.layout.activity_choice, null);
                dialog.setView(choiceView);

                listChoice = (ListView)findViewById(R.id.listId);

                ArrayAdapter<String> adapterChoice = new ArrayAdapter<String>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    arrayList
                ){
                public View getView(int position, View convertView, ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);

                        TextView textView = (TextView) view.findViewById(android.R.id.text1);
                        textView.setTextColor(Color.BLACK);
                        return view;
                    }
                };

                listChoice.setAdapter(adapterChoice);
                listChoice.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                        int codPosition = position;
                        choiceBreed = listChoice.getItemAtPosition(codPosition).toString();
                        toList.setText(choiceBreed);

                    }
                });

                dialog.setTitle("Selecione a raça do animal");
                dialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        toList.setText(choiceBreed);
                    }
                });

                dialog.create();
                dialog.show();

            }
        });

        enter = (Button) findViewById(R.id.enterButton);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toWin = new Intent(RegisterActivity.this, AnimalsActivity.class);

                EditText animalName = (EditText) findViewById(R.id.animalName);
                String nameAnimal = animalName.getText().toString();
                toWin.putExtra("nameAnimal", nameAnimal);

                EditText birthAnimal = (EditText) findViewById(R.id.birthdateAnimal);
                String animalBirth = birthAnimal.getText().toString();
                toWin.putExtra("animalBirth", animalBirth);

                EditText weightAnimal = (EditText) findViewById(R.id.weightAnimal);
                String animalWeight = weightAnimal.getText().toString();
                toWin.putExtra("animalWeight", animalWeight);

                EditText larguraAnimal = (EditText) findViewById(R.id.larguraAnimal);
                String animalLargura = larguraAnimal.getText().toString();
                toWin.putExtra("animalLargura", animalLargura);

                EditText chefName = (EditText) findViewById(R.id.chefName);
                String nameChef = chefName.getText().toString();
                toWin.putExtra("nameChef", nameChef);

                EditText streetAnimal = (EditText) findViewById(R.id.streetAnimal);
                String animalStreet = streetAnimal.getText().toString();
                toWin.putExtra("animalStreet", animalStreet);

                EditText streetNumberAnimal = (EditText) findViewById(R.id.streetNumberAnimal);
                String animalNumberStreet = streetNumberAnimal.getText().toString();
                toWin.putExtra("animalNumberStreet", animalNumberStreet);

                EditText chefCPF = (EditText) findViewById(R.id.chefCPF);
                String cpfCHEF = chefCPF.getText().toString();
                toWin.putExtra("cpfCHEF", cpfCHEF);

                EditText chefTEL = (EditText) findViewById(R.id.chefTEL);
                String telCHEF = chefTEL.getText().toString();
                toWin.putExtra("telCHEF", telCHEF);

                toWin.putExtra("selectedBreed", selectedBreed);

                startActivity(toWin);

            }
        });

    }

    View.OnClickListener clickDog = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            for (int i=0; i<5; i++){
                arrayList[i] = arrayDog[i];
            }
            selectedBreed = "Cachorro";

        }
    };

    View.OnClickListener clickCat = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            for (int i=0; i<5; i++){
                arrayList[i] = arrayCat[i];
            }
            selectedBreed = "Gato";
        }
    };

    View.OnClickListener clickBird = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            for (int i=0; i<5; i++){
                arrayList[i] = arrayBird[i];
            }
            selectedBreed = "Pássaro";
        }
    };

}