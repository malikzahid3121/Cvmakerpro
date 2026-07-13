package com.cvmakerpro.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TemplateActivity extends AppCompatActivity {

    Button btnModern, btnClassic, btnSimple;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);


        btnModern = findViewById(R.id.btnModern);
        btnClassic = findViewById(R.id.btnClassic);
        btnSimple = findViewById(R.id.btnSimple);


        preferences = getSharedPreferences(
                "CVMakerPro",
                MODE_PRIVATE
        );


        btnModern.setOnClickListener(v -> {

            saveTemplate("Modern");

            Toast.makeText(this,
                    "Modern Template Selected",
                    Toast.LENGTH_SHORT).show();

            finish();
        });


        btnClassic.setOnClickListener(v -> {

            saveTemplate("Classic");

            Toast.makeText(this,
                    "Classic Template Selected",
                    Toast.LENGTH_SHORT).show();

            finish();
        });


        btnSimple.setOnClickListener(v -> {

            saveTemplate("Simple");

            Toast.makeText(this,
                    "Simple Template Selected",
                    Toast.LENGTH_SHORT).show();

            finish();
        });

    }


    private void saveTemplate(String template){

        preferences.edit()
                .putString("template", template)
                .apply();

    }

}