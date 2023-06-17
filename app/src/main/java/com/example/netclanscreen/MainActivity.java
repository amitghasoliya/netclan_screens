package com.example.netclanscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.slider.Slider;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    RadioButton radioButton;
    ImageView back;
    Slider slider;
    TextView textCount;
    Button save;
    EditText editText;
    ArrayList<String> arr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        radioButton = findViewById(R.id.radioButton);
        save = findViewById(R.id.save);
        slider = findViewById(R.id.slider);
        back = findViewById(R.id.back);
        textCount = findViewById(R.id.textCount);
        editText = findViewById(R.id.editText);

        arr.add("Available | Hey Let Us Connect");
        arr.add("Away | Stay Discreet And Watch");
        arr.add("Buzy | Do Not Distrub | Will Catch Up Later");
        arr.add("SOS | Emergency! Need Assistance! Help");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arr);
        spinner.setAdapter(adapter);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Saved!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ExploreScreen.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = s.toString();
                int currentLength = text.length();
                textCount.setText(currentLength+"/100");
            }
        });

    }
}