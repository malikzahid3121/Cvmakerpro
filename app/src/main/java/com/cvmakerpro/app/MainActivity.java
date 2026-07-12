package com.cvmakerpro.app;

import android.content.Intent;
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


        btnDownload.setOnClickListener(v -> openPreview());

    }



    private void openPreview() {


        Intent intent = new Intent(MainActivity.this, PreviewActivity.class);


        intent.putExtra("name", etName.getText().toString());
        intent.putExtra("email", etEmail.getText().toString());
        intent.putExtra("phone", etPhone.getText().toString());
        intent.putExtra("education", etEducation.getText().toString());
        intent.putExtra("experience", etExperience.getText().toString());
        intent.putExtra("skills", etSkills.getText().toString());


        startActivity(intent);

    }



    private void createPDF() {


        String name = etName.getText().toString().trim();


        try {


            String pdfPath = Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                    .toString();


            File file = new File(pdfPath, "CV_" + name + ".pdf");


            PdfWriter writer = new PdfWriter(file);

            PdfDocument pdfDocument = new PdfDocument(writer);

            Document document = new Document(pdfDocument);



            document.add(new Paragraph("CURRICULUM VITAE")
                    .setBold()
                    .setFontSize(22));


            document.add(new Paragraph("\nName: "
                    + etName.getText().toString()));


            document.add(new Paragraph("Email: "
                    + etEmail.getText().toString()));


            document.add(new Paragraph("Phone: "
                    + etPhone.getText().toString()));



            document.add(new Paragraph("\nEDUCATION")
                    .setBold()
                    .setFontSize(16));


            document.add(new Paragraph(
                    etEducation.getText().toString()
            ));



            document.add(new Paragraph("\nWORK EXPERIENCE")
                    .setBold()
                    .setFontSize(16));


            document.add(new Paragraph(
                    etExperience.getText().toString()
            ));



            document.add(new Paragraph("\nSKILLS")
                    .setBold()
                    .setFontSize(16));


            document.add(new Paragraph(
                    etSkills.getText().toString()
            ));



            document.close();


            Toast.makeText(
                    this,
                    "PDF Created Successfully",
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