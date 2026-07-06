package com.cvmakerpro.app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EducationActivity extends AppCompatActivity {

    EditText etDegree, etUniversity, etYear;
    Button btnNextEdu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        etDegree = findViewById(R.id.etDegree);
        etUniversity = findViewById(R.id.etUniversity);
        etYear = findViewById(R.id.etYear);
        btnNextEdu = findViewById(R.id.btnNextEdu);

        // MainActivity se data lena
        String name = getIntent().getStringExtra("NAME");
        String email = getIntent().getStringExtra("EMAIL");
        String phone = getIntent().getStringExtra("PHONE");

        btnNextEdu.setOnClickListener(v -> {
            String degree = etDegree.getText().toString().trim();
            String university = etUniversity.getText().toString().trim();
            String year = etYear.getText().toString().trim();

            if(degree.isEmpty() || university.isEmpty() || year.isEmpty()){
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                // SecondActivity me data bhejna
                Intent intent = new Intent(EducationActivity.this, SecondActivity.class);
                intent.putExtra("NAME", name);
                intent.putExtra("EMAIL", email);
                intent.putExtra("PHONE", phone);
                intent.putExtra("DEGREE", degree);
                intent.putExtra("UNIVERSITY", university);
                intent.putExtra("YEAR", year);
                startActivity(intent);
            }
        });
    }
}