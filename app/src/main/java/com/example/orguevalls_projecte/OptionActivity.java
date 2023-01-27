package com.example.orguevalls_projecte;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OptionActivity extends AppCompatActivity {

    // Variable declaration
    private TextView nEncerts;
    private TextView nErrors;
    private Button bRestablsih;

    // Database handler declaration
    public DBHandler dbh = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        setTitle(R.string.bOpts);

        // Links variables to with physical objects
        nEncerts = findViewById(R.id.textNEncerts);
        nErrors = findViewById(R.id.textNErrors);
        bRestablsih = findViewById(R.id.buttonRestablsih);

        // Sets text to TextViews
        nEncerts.setText(String.valueOf(dbh.getEncerts()));
        nErrors.setText(String.valueOf(dbh.getErrors()));

        // When bRestablsih is clicked, opens new AlertDialog to check if user wants to reestablish data
        bRestablsih.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(OptionActivity.this);
                builder.setCancelable(true);
                builder.setTitle(R.string.confirmacio);
                builder.setMessage(R.string.estasSegur);
                builder.setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // When clicked reestablishes data and shows data indicating so
                                dbh.reestablishData();
                                if (dbh.getEncerts() == 0 && dbh.getErrors() == 0) {
                                    Toast toast = Toast.makeText(OptionActivity.this, "S'han reestablert les dades! Reinicïi la aplicació!", Toast.LENGTH_LONG);
                                    toast.show();
                                }
                            }
                        });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }
}