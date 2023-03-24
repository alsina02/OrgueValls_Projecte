package com.example.orguevalls_projecte;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class A21 extends AppCompatActivity {

    private Button ba22;
    public DBHandler dbh = new DBHandler(this);


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a21);

        ba22 = findViewById(R.id.botoTODOGAY);
        ba22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(A21.this, A22.class);
                A21.this.startActivity(myIntent);
            }
        });


    }
}