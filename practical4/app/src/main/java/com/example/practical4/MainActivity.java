package com.example.practical4;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // AutoCompleteTextView Setup
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Grape", "Mango", "Orange", "Papaya"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, fruits);
        autoCompleteTextView.setAdapter(adapter);

        // Button Click Event
        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> Toast.makeText(MainActivity.this, "Button Clicked!", Toast.LENGTH_SHORT).show());

        // ImageButton Click Event
        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(view -> Toast.makeText(MainActivity.this, "Image Button Clicked!", Toast.LENGTH_SHORT).show());

        // ToggleButton Click Event
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(MainActivity.this, "Toggle: ON", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Toggle: OFF", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
