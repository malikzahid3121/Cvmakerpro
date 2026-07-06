package com.cvmakerpro.app;

import androidx.appcompat.app.AppCompatActivity;
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

        btnNextEdu.setOnClickListener(v -> {
            String degree = etDegree.getText().toString();
            if(degree.isEmpty()){
                Toast.makeText(this, "Please enter your degree", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Education Saved", Toast.LENGTH_SHORT).show();
            }
        });
    }
}