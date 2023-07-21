package com.example.netclanscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProfileScreen extends AppCompatActivity {
    ImageView backToNotesScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        backToNotesScreen = findViewById(R.id.backToNotesScreen);
        backToNotesScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),notesScreen.class);
                startActivity(intent);
            }
        });
    }
}