package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practical5.R;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private RadioGroup radioGroupGender;
    private CheckBox checkBoxAgree;
    private Spinner spinnerState;
    private ToggleButton toggleButton;
    private SeekBar seekBar;
    private Switch switchMode;
    private ProgressBar progressBar;
    private TextView textViewResult;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.practical5.R.layout.activity_main);

        // Initializing UI Components
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        checkBoxAgree = findViewById(R.id.checkBoxAgree);
        spinnerState = findViewById(R.id.spinnerState);
        toggleButton = findViewById(R.id.toggleButton);
        seekBar = findViewById(R.id.seekBar);
        switchMode = findViewById(R.id.switchMode);
        progressBar = findViewById(R.id.progressBar);
        textViewResult = findViewById(R.id.textViewResult);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Spinner Data
        String[] states = {"Select State", "Andhra Pradesh", "Delhi", "Karnataka", "Maharashtra", "Tamil Nadu", "Uttar Pradesh"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, states);
        spinnerState.setAdapter(adapter);

        // SeekBar Change Listener
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressBar.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // Submit Button Click Event
        buttonSubmit.setOnClickListener(view -> {
            String username = editTextUsername.getText().toString();
            String password = editTextPassword.getText().toString();
            String gender = ((RadioButton) findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();
            String state = spinnerState.getSelectedItem().toString();
            boolean agreed = checkBoxAgree.isChecked();
            boolean toggleStatus = toggleButton.isChecked();
            boolean darkMode = switchMode.isChecked();
            int progress = seekBar.getProgress();

            // Display the result
            String result = "Username: " + username + "\nPassword: " + password +
                    "\nGender: " + gender + "\nState: " + state +
                    "\nAgreed: " + agreed + "\nToggle: " + toggleStatus +
                    "\nDark Mode: " + darkMode + "\nSeekBar Value: " + progress;

            textViewResult.setText(result);
        });
    }
}
