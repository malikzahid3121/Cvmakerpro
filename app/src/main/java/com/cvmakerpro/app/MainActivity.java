package com.cvmakerpro.app;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPhone, etEducation, etExperience, etSkills;
    Button btnDownload;

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

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    1
            );
        }

        btnDownload.setOnClickListener(v -> createPDF());
    }

    private void createPDF() {

        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String education = etEducation.getText().toString().trim();
        String experience = etExperience.getText().toString().trim();
        String skills = etSkills.getText().toString().trim();

        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter Full Name", Toast.LENGTH_SHORT).show();
            return;
        }

        try {

            String pdfPath = Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                    .toString();

            File file = new File(pdfPath, "CV_" + name + ".pdf");

            PdfWriter writer = new PdfWriter(file);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            document.add(new Paragraph(name)
                    .setFontSize(26)
                    .setBold());

            document.add(new Paragraph("Email: " + email));
            document.add(new Paragraph("Phone: " + phone));

            document.add(new Paragraph("--------------------------------"));

            document.add(new Paragraph("EDUCATION")
                    .setBold()
                    .setFontSize(16));

            document.add(new Paragraph(education));

            document.add(new Paragraph("WORK EXPERIENCE")
                    .setBold()
                    .setFontSize(16));

            document.add(new Paragraph(experience));

            document.add(new Paragraph("SKILLS")
                    .setBold()
                    .setFontSize(16));

            document.add(new Paragraph(skills));

            document.close();

            Toast.makeText(
                    this,
                    "PDF Saved in Downloads: CV_" + name + ".pdf",
                    Toast.LENGTH_LONG
            ).show();

        } catch (Exception e) {

            e.printStackTrace();

            Toast.makeText(
                    this,
                    "Error: " + e.getMessage(),
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}