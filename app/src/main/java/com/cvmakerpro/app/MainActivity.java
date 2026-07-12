package com.cvmakerpro.app;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;

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
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String education = etEducation.getText().toString().trim();
        String experience = etExperience.getText().toString().trim();
        String skills = etSkills.getText().toString().trim();


        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter name", Toast.LENGTH_SHORT).show();
            return;
        }


        try {

            String path = Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                    .toString();

            File file = new File(path, "CV_" + name + ".pdf");


            PdfWriter writer = new PdfWriter(file);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);


            Paragraph title = new Paragraph("CURRICULUM VITAE")
                    .setBold()
                    .setFontSize(22)
                    .setTextAlignment(TextAlignment.CENTER);

            document.add(title);


            document.add(new Paragraph("\n" + name)
                    .setBold()
                    .setFontSize(18));


            document.add(new Paragraph("Email: " + email));
            document.add(new Paragraph("Phone: " + phone));


            document.add(new Paragraph("\nEDUCATION")
                    .setBold()
                    .setFontSize(15));

            document.add(new Paragraph(education));


            document.add(new Paragraph("\nWORK EXPERIENCE")
                    .setBold()
                    .setFontSize(15));

            document.add(new Paragraph(experience));


            document.add(new Paragraph("\nSKILLS")
                    .setBold()
                    .setFontSize(15));

            document.add(new Paragraph(skills));


            document.close();


            Toast.makeText(
                    this,
                    "Professional CV PDF Created",
                    Toast.LENGTH_LONG
            ).show();


        } catch (Exception e) {

            Toast.makeText(
                    this,
                    "Error: " + e.getMessage(),
                    Toast.LENGTH_LONG
            ).show();

        }

    }
}