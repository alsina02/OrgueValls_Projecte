package com.example.orguevalls_projecte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button bHistoria;
    private Button bQA;
    private Button bOpts;

    public DBHandler dbh = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbh.cargarDades();

        bHistoria = findViewById(R.id.botoHistoria);
        bQA = findViewById(R.id.botoQA);
        bOpts = findViewById(R.id.botoOpts);

        bHistoria.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, HistoryActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        bQA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, QuestActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        bOpts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, OptionActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

    }
}