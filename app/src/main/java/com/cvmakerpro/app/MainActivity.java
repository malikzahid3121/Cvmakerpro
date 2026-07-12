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

        btnDownload.setOnClickListener(v -> createPDF());
    }

    private void createPDF() {

        String name = etName.getText().toString().trim();

        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter Full Name", Toast.LENGTH_SHORT).show();
            return;
        }

        try {

            String path = Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                    .toString();

            File file = new File(path, "CV_" + name + ".pdf");

            PdfWriter writer = new PdfWriter(file);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph(name)
                    .setBold()
                    .setFontSize(24));

            document.add(new Paragraph("Email: " + etEmail.getText().toString()));
            document.add(new Paragraph("Phone: " + etPhone.getText().toString()));

            document.add(new Paragraph("EDUCATION"));
            document.add(new Paragraph(etEducation.getText().toString()));

            document.add(new Paragraph("EXPERIENCE"));
            document.add(new Paragraph(etExperience.getText().toString()));

            document.add(new Paragraph("SKILLS"));
            document.add(new Paragraph(etSkills.getText().toString()));

            document.close();

            Toast.makeText(this, "PDF Created Successfully", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}