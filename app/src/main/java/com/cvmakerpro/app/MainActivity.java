package com.cvmakerpro.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPhone, etEducation, etExperience, etSkills;
    Button btnDownload, btnTemplate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etEducation = findViewById(R.id.etEducation);
        etExperience = findViewById(R.id.etExperience);
        etSkills = findViewById(R.id.etSkills);

        btnDownload = findViewById(R.id.btnDownload);
        btnTemplate = findViewById(R.id.btnTemplate);


        btnDownload.setOnClickListener(v -> openPreview());


        btnTemplate.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    TemplateActivity.class
            );

            startActivity(intent);

        });

    }



    private void openPreview() {

        Intent intent = new Intent(
                MainActivity.this,
                PreviewActivity.class
        );


        intent.putExtra("name",
                etName.getText().toString());

        intent.putExtra("email",
                etEmail.getText().toString());

        intent.putExtra("phone",
                etPhone.getText().toString());

        intent.putExtra("education",
                etEducation.getText().toString());

        intent.putExtra("experience",
                etExperience.getText().toString());

        intent.putExtra("skills",
                etSkills.getText().toString());


        startActivity(intent);

    }

}