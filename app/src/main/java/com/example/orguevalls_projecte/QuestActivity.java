package com.example.orguevalls_projecte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuestActivity extends AppCompatActivity {


    private Button ba11;

    public DBHandler dbh = new DBHandler(this);
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);
        setTitle(R.string.bQA);

        ba11 = findViewById(R.id.botoA11);

        ba11.setOnClickListener(new View.OnClickListener() {
          @Override
                      public void onClick(View view) {
              Intent myIntent = new Intent(QuestActivity.this, A11.class);
              QuestActivity.this.startActivity(myIntent);
                }
            });

    }
}