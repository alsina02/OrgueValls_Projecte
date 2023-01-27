package com.example.orguevalls_projecte;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class A11 extends AppCompatActivity {

    private Button ba12;



    public DBHandler dbh = new DBHandler(this);
    @SuppressLint("MissingInflatedId")
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a11);
        setTitle(R.string.bQA);


        ba12 = findViewById(R.id.botoA12);

        ba12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(A11.this, A12.class);
                A11.this.startActivity(myIntent);
            }
        });


    }
}