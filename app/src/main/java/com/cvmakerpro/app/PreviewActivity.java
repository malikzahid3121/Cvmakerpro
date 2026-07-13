package com.cvmakerpro.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;

public class PreviewActivity extends AppCompatActivity {

    private TextView tvPreview;
    private Button btnExportPdf, btnShare;

    private String cvText;
    private String selectedTemplate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);


        tvPreview = findViewById(R.id.tvPreview);
        btnExportPdf = findViewById(R.id.btnExportPdf);
        btnShare = findViewById(R.id.btnShare);


        SharedPreferences preferences =
                getSharedPreferences("CVMakerPro", MODE_PRIVATE);

        selectedTemplate =
                preferences.getString("template", "Modern");


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


        cvText = createTemplateCV(
                name,
                email,
                phone,
                education,
                experience,
                skills
        );


        tvPreview.setText(cvText);


        btnExportPdf.setOnClickListener(v -> createPDF());


        btnShare.setOnClickListener(v -> {

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, cvText);

            startActivity(Intent.createChooser(
                    shareIntent,
                    "Share CV"
            ));

        });

    }


    private String createTemplateCV(
            String name,
            String email,
            String phone,
            String education,
            String experience,
            String skills
    ){

        if(selectedTemplate.equals("Classic")){

            return
            "========================\n" +
            "       CURRICULUM VITAE\n" +
            "========================\n\n" +

            "NAME\n" + name + "\n\n" +
            "CONTACT\n" +
            email + "\n" +
            phone + "\n\n" +

            "EDUCATION\n" +
            education + "\n\n" +

            "EXPERIENCE\n" +
            experience + "\n\n" +

            "SKILLS\n" +
            skills;


        } else if(selectedTemplate.equals("Simple")){


            return
            "CV MAKER PRO\n\n" +
            name + "\n" +
            email + "\n" +
            phone + "\n\n" +

            education + "\n\n" +
            experience + "\n\n" +
            skills;


        } else {


            return
            "★★★★★★★★★★★★\n" +
            "     CV MAKER PRO\n" +
            "   PROFESSIONAL CV\n" +
            "★★★★★★★★★★★★\n\n" +

            "👤 PERSONAL INFORMATION\n\n" +
            "Name: " + name + "\n" +
            "Email: " + email + "\n" +
            "Phone: " + phone + "\n\n" +

            "🎓 EDUCATION\n" +
            education + "\n\n" +

            "💼 EXPERIENCE\n" +
            experience + "\n\n" +

            "🛠 SKILLS\n" +
            skills;

        }

    }



    private void createPDF() {

        try {

            PdfDocument document = new PdfDocument();

            PdfDocument.PageInfo pageInfo =
                    new PdfDocument.PageInfo.Builder(
                            595,
                            842,
                            1
                    ).create();


            PdfDocument.Page page =
                    document.startPage(pageInfo);


            page.getCanvas().drawText(
                    cvText,
                    40,
                    60,
                    new android.graphics.Paint()
            );


            document.finishPage(page);


            File file = new File(
                    getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS),
                    "CVMakerPro_CV.pdf"
            );


            FileOutputStream output =
                    new FileOutputStream(file);


            document.writeTo(output);

            document.close();
            output.close();


            Toast.makeText(
                    this,
                    "PDF Created Successfully",
                    Toast.LENGTH_LONG
            ).show();


        } catch (Exception e) {

            Toast.makeText(
                    this,
                    "PDF Error: " + e.getMessage(),
                    Toast.LENGTH_LONG
            ).show();
        }
    }
}