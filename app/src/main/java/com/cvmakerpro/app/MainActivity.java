package com.cvmakerpro.app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPhone;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(v -> {
            String name = etName.getText().toString();
            if(name.isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Welcome " + name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}