package com.example.orguevalls_projecte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bHistoria;
    private Button bQA;
    private Button bCantates;
    private Button bOpts;

    public DBHandler dbh = new DBHandler(this);

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbh.cargarDades();

        bHistoria = findViewById(R.id.botoHistoria);
        bQA = findViewById(R.id.botoQA);
        bOpts = findViewById(R.id.botoOpts);
        bCantates = findViewById(R.id.botoCantates);

        mp = MediaPlayer.create(this, R.raw.lux_aeterna);
        mp.setLooping(true);

        if (dbh.isMusicaEnabled()) {
            mp.start();
        }

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
                startActivityForResult(myIntent, 1);
            }
        });

        bCantates.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, CantatesActivity.class);
                MainActivity.this.startActivity(myIntent);
                mp.pause();
            }
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("adsfasdfasdf***ASDFSADFAS***ADSFASDFAS***ADSFASF****ASDASF");
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String strEditText = data.getStringExtra("musica");

                switch (strEditText) {
                    case "true": mp.start();
                        break;
                    case "false": mp.pause();
                        break;
                }
            }
        }
    }
}