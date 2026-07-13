package com.cvmakerpro.app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PreviewActivity extends AppCompatActivity {

    private TextView tvPreview;

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

        if (name == null) name = "";
        if (email == null) email = "";
        if (phone == null) phone = "";
        if (education == null) education = "";
        if (experience == null) experience = "";
        if (skills == null) skills = "";

        String cv =
                "══════════════════════════════\n" +
                "        CV MAKER PRO\n" +
                "   PROFESSIONAL RESUME\n" +
                "══════════════════════════════\n\n" +

                "👤 PERSONAL INFORMATION\n\n" +
                "Name\n" + name + "\n\n" +
                "Email\n" + email + "\n\n" +
                "Phone\n" + phone + "\n\n" +

                "🎓 EDUCATION\n\n" +
                education + "\n\n" +

                "💼 WORK EXPERIENCE\n\n" +
                experience + "\n\n" +

                "🛠 SKILLS\n\n" +
                skills + "\n\n" +

                "══════════════════════════════\n" +
                "Generated with CVMakerPro";

        tvPreview.setText(cv);
    }
}