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

    private TextView nEncerts;
    private TextView nErrors;
    private Button bRestablsih;
    private Button bEnable;
    private Button bDisable;
    public DBHandler dbh = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        setTitle(R.string.bOpts);

        nEncerts = findViewById(R.id.textNEncerts);
        nErrors = findViewById(R.id.textNErrors);
        bRestablsih = findViewById(R.id.buttonRestablsih);
        bEnable = findViewById(R.id.buttonEnableMusica);
        bDisable = findViewById(R.id.buttonDisableMusica);

        nEncerts.setText(String.valueOf(dbh.getEncerts()));
        nErrors.setText(String.valueOf(dbh.getErrors()));

        if (dbh.isMusicaEnabled()) {
            bEnable.setVisibility(View.GONE);
            bDisable.setVisibility(View.VISIBLE);
        } else {
            bDisable.setVisibility(View.GONE);
            bEnable.setVisibility(View.VISIBLE);
        }

        bRestablsih.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(OptionActivity.this);
                builder.setCancelable(true);
                builder.setTitle(R.string.confirmacio);
                builder.setMessage(R.string.estasSegur);
                builder.setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
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

        bEnable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("musica", "true");
                setResult(RESULT_OK, intent);
                finish();
                dbh.enableMusica();
            }
        });

        bDisable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("musica", "false");
                setResult(RESULT_OK, intent);
                finish();
                dbh.disableMusica();
            }
        });

    }
}