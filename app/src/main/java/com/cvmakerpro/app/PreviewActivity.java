package com.cvmakerpro.app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PreviewActivity extends AppCompatActivity {


    TextView tvPreview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_preview);


        tvPreview = findViewById(R.id.tvPreview);


        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String phone = getIntent().getStringExtra("phone");
        String education = getIntent().getStringExtra("education");
        String experience = getIntent().getStringExtra("experience");
        String skills = getIntent().getStringExtra("skills");


        String cv =

                "        CVMAKERPRO\n" +
                "   PROFESSIONAL RESUME\n\n" +

                "PERSONAL INFORMATION\n" +
                "------------------------\n" +
                "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phone + "\n\n" +

                "EDUCATION\n" +
                "------------------------\n" +
                education + "\n\n" +

                "WORK EXPERIENCE\n" +
                "------------------------\n" +
                experience + "\n\n" +

                "SKILLS\n" +
                "------------------------\n" +
                skills;


        tvPreview.setText(cv);

    }

}