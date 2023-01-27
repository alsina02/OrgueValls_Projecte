package com.example.orguevalls_projecte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Variable declaration
    private Button bHistoria;
    private Button bQA;
    private Button bOpts;

    // Database handler declaration
    public DBHandler dbh = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creates user if it doesn't exists
        dbh.cargarDades();

        // Links button with physical button
        bHistoria = findViewById(R.id.botoHistoria);
        bQA = findViewById(R.id.botoQA);
        bOpts = findViewById(R.id.botoOpts);

        // When bHistoria is clicked, loads History Activity
        bHistoria.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, HistoryActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        // When bQA is clicked, loads Questions Activity
        bQA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, QuestActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        // When bOpts is clicked, loads Option Activity
        bOpts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, OptionActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

    }
}