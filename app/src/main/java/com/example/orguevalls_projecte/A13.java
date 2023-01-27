package com.example.orguevalls_projecte;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class A13 extends AppCompatActivity {

    private Button ba14;
    public DBHandler dbh = new DBHandler(this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a13);

        ba14 = findViewById(R.id.botoA14);
        ba14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(A13.this, A14.class);
                A13.this.startActivity(myIntent);
            }
        });


    }
}