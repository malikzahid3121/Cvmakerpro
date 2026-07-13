package com.cvmakerpro.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PreviewActivity extends AppCompatActivity {

    private TextView tvPreview;
    private Button btnExportPdf, btnShare;

    private String cvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        tvPreview = findViewById(R.id.tvPreview);
        btnExportPdf = findViewById(R.id.btnExportPdf);
        btnShare = findViewById(R.id.btnShare);

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

        cvText =
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

        tvPreview.setText(cvText);


        btnExportPdf.setOnClickListener(v -> {
            Toast.makeText(this,
                    "PDF Export Feature Next Step",
                    Toast.LENGTH_SHORT).show();
        });


        btnShare.setOnClickListener(v -> {

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, cvText);

            startActivity(
                    Intent.createChooser(shareIntent, "Share CV")
            );
        });
    }
}