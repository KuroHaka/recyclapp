package com.gamecode.recyclapp.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.gamecode.recyclapp.R;

public class NewPost extends AppCompatActivity {

    ImageView imagen;
    String tag;
    EditText desc;
    EditText title;
    Button publish;
    Button but1;
    Button but2;
    Button but3;
    Button but4;
    Button but5;
    Button but6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        imagen = findViewById(R.id.imagenId);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imagen = findViewById(R.id.imagenId);
        publish = findViewById(R.id.publish);
        but1 = findViewById(R.id.button);
        but2 = findViewById(R.id.button2);
        but3 = findViewById(R.id.button3);
        but4 = findViewById(R.id.button4);
        but5 = findViewById(R.id.button5);
        but6 = findViewById(R.id.button6);
        setTagsDefaultColor();

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTagsDefaultColor();
                but1.setBackgroundColor(getResources().getColor(R.color.colorAccentGreen));
                tag = but1.getText().toString();
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTagsDefaultColor();
                but2.setBackgroundColor(getResources().getColor(R.color.colorAccentGreen));
                tag = but2.getText().toString();
            }
        });
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTagsDefaultColor();
                but3.setBackgroundColor(getResources().getColor(R.color.colorAccentGreen));
                tag = but3.getText().toString();
            }
        });
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTagsDefaultColor();
                but4.setBackgroundColor(getResources().getColor(R.color.colorAccentGreen));
                tag = but4.getText().toString();
            }
        });
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTagsDefaultColor();
                but5.setBackgroundColor(getResources().getColor(R.color.colorAccentGreen));
                tag = but5.getText().toString();
            }
        });
        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTagsDefaultColor();
                but6.setBackgroundColor(getResources().getColor(R.color.colorAccentGreen));
                tag = but6.getText().toString();
            }
        });

    }

    public void onclicK(View view) {
        cargarImagen();
    }

    private void cargarImagen() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent,"Select App"),5);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)   {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            Uri path = data.getData();
            imagen.setImageURI(path);
        }
    }

    void setTagsDefaultColor(){
        but1.setBackgroundColor(getResources().getColor(R.color.colorAlmostWhite));
        but2.setBackgroundColor(getResources().getColor(R.color.colorAlmostWhite));
        but3.setBackgroundColor(getResources().getColor(R.color.colorAlmostWhite));
        but4.setBackgroundColor(getResources().getColor(R.color.colorAlmostWhite));
        but5.setBackgroundColor(getResources().getColor(R.color.colorAlmostWhite));
        but6.setBackgroundColor(getResources().getColor(R.color.colorAlmostWhite));
    }

}

