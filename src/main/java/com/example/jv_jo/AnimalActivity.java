package com.example.jv_jo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jv_jo.firstproject.R;

public class AnimalActivity extends Activity {

    String desc;
    ImageView animalImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        Bundle data = getIntent().getExtras();

        animalImg = (ImageView) findViewById(R.id.animalImg);
        animalImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra("return-data", true);
                startActivityForResult(intent, 1337);
            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK)
        {
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            animalImg.setImageBitmap(bitmap);
        }
    }

}
