package com.cvmakerpro.app;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TemplateActivity extends AppCompatActivity {

    Button btnModern, btnClassic, btnSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);

        btnModern = findViewById(R.id.btnModern);
        btnClassic = findViewById(R.id.btnClassic);
        btnSimple = findViewById(R.id.btnSimple);


        btnModern.setOnClickListener(v -> {
            Toast.makeText(this,
                    "Modern Template Selected",
                    Toast.LENGTH_SHORT).show();
        });


        btnClassic.setOnClickListener(v -> {
            Toast.makeText(this,
                    "Classic Template Selected",
                    Toast.LENGTH_SHORT).show();
        });


        btnSimple.setOnClickListener(v -> {
            Toast.makeText(this,
                    "Simple Template Selected",
                    Toast.LENGTH_SHORT).show();
        });
    }
}