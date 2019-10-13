package com.gamecode.recyclapp;

import android.content.Intent;
import android.os.Bundle;

import com.gamecode.recyclapp.ui.NewPost;
import com.gamecode.recyclapp.ui.home.HomePage;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class Tags extends AppCompatActivity {

    Button btnCan, btnPlastic, btnPaper, btnGlass, btnJar, btnBulb;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tags);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnCan = findViewById(R.id.btnCan);
        btnPlastic = findViewById(R.id.btnPlastic);
        btnBulb = findViewById(R.id.btnBulb);
        btnGlass = findViewById(R.id.btnGlass);
        btnJar = findViewById(R.id.btnJar);
        btnPaper = findViewById(R.id.btnPaper);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Tags.this, NewPost.class);
                startActivity(intent);
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        btnCan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tags.this, SearchResults.class);
                String strName = "can";
                i.putExtra("STRING_I_NEED", strName);
            }
        });

        btnPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tags.this, SearchResults.class);
                String strName = "paper";
                i.putExtra("STRING_I_NEED", strName);
            }
        });

        btnJar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tags.this, SearchResults.class);
                String strName = "jar";
                i.putExtra("STRING_I_NEED", strName);
            }
        });

        btnGlass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tags.this, SearchResults.class);
                String strName = "glass";
                i.putExtra("STRING_I_NEED", strName);
            }
        });

        btnBulb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tags.this, SearchResults.class);
                String strName = "bulb";
                i.putExtra("STRING_I_NEED", strName);
            }
        });

        btnPlastic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Tags.this, SearchResults.class);
                String strName = "plastic";
                i.putExtra("STRING_I_NEED", strName);
            }
        });
    }

}
