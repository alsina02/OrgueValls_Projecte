package com.example.orguevalls_projecte;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class A14 extends AppCompatActivity {

    private Button ba21;
    public DBHandler dbh = new DBHandler(this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a14);

        ba21 = findViewById(R.id.botoA21);
        ba21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(A14.this, A31.class);
                A14.this.startActivity(myIntent);
            }
        });


    }
}