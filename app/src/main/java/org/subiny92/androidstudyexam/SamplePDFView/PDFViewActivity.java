package org.subiny92.androidstudyexam.SamplePDFView;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.subiny92.androidstudyexam.R;

import java.io.File;

public class PDFViewActivity extends AppCompatActivity {

    private EditText et_fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfview);

        et_fileName = (EditText) findViewById(R.id.et_fileName);
        findViewById(R.id.btn_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fileName = et_fileName.getText().toString();

                if (fileName.length() > 0) {
                    openPDF(fileName.trim());
                } else {
                    Toast.makeText(PDFViewActivity.this, "PDF 파일명을 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void openPDF(String fileName) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
                openPDF(fileName);
            }
        }
        String sdcardFolder = Environment.getExternalStorageDirectory().getAbsolutePath();
        String filePath = sdcardFolder + File.separator + fileName;

        File file = new File(filePath);
        if (file.exists()) {
            Uri uri = FileProvider.getUriForFile(this,   "org.subiny92.androidstudyexam.SamplePDFView.PDFViewActivity", file);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri, "application/pdf");

            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(this, "PDF 파일을 보기 위한 뷰어 앱이 없습니다.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "PDF 파일이 없습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
