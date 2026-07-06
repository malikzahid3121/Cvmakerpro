package com.cvmakerpro.app;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    Button btnGeneratePDF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnGeneratePDF = findViewById(R.id.btnGeneratePDF);

        String name = getIntent().getStringExtra("NAME");
        String email = getIntent().getStringExtra("EMAIL");
        String phone = getIntent().getStringExtra("PHONE");
        String degree = getIntent().getStringExtra("DEGREE");
        String university = getIntent().getStringExtra("UNIVERSITY");
        String year = getIntent().getStringExtra("YEAR");

        btnGeneratePDF.setOnClickListener(v -> createPDF(name, email, phone, degree, university, year));
    }

    private void createPDF(String name, String email, String phone, String degree, String university, String year) {
        PdfDocument pdfDocument = new PdfDocument();
        Paint paint = new Paint();
        Paint titlePaint = new Paint();

        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(595, 842, 1).create();
        PdfDocument.Page page = pdfDocument.startPage(pageInfo);
        Canvas canvas = page.getCanvas();

        titlePaint.setTextSize(24);
        titlePaint.setFakeBoldText(true);
        canvas.drawText("CV - " + name, 40, 80, titlePaint);

        paint.setTextSize(16);
        canvas.drawText("Name: " + name, 40, 130, paint);
        canvas.drawText("Email: " + email, 40, 160, paint);
        canvas.drawText("Phone: " + phone, 40, 190, paint);
        canvas.drawText("Education: " + degree, 40, 240, paint);
        canvas.drawText("University: " + university, 40, 270, paint);
        canvas.drawText("Year: " + year, 40, 300, paint);

        pdfDocument.finishPage(page);

        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), name + "_CV.pdf");
        try {
            pdfDocument.writeTo(new FileOutputStream(file));
            Toast.makeText(this, "PDF Saved in Downloads", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        pdfDocument.close();
    }
}