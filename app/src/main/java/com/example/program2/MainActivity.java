package com.example.program2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button ok;
    TextView result;
    Spinner spinner;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ok = findViewById(R.id.buttonOk);
        result = findViewById(R.id.textViewResult);
        spinner = findViewById(R.id.spinnerCountry);

        adapter = ArrayAdapter.createFromResource(this,R.array.countries
                ,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String country = adapterView.getItemAtPosition(i).toString();
                result.setText(country);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogMessage();
            }
        });
    }

    private void showDialogMessage() {
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(this);
        alertdialog.setTitle("Sure")
                .setMessage("Are you sure about the country?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        result.setText("");
                    }
                }).show();
        alertdialog.create();
    }
}