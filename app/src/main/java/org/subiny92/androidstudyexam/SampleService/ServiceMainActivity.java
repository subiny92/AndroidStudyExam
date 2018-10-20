package org.subiny92.androidstudyexam.SampleService;

import android.app.Service;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.subiny92.androidstudyexam.R;

public class ServiceMainActivity extends AppCompatActivity {

    private EditText et_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_main);
        et_service = (EditText) findViewById(R.id.et_service);

    }

    public void ServiceClicked(View view) {
        String name = et_service.getText().toString();
        Intent intent = new Intent(ServiceMainActivity.this, MyService.class);
        intent.putExtra("command", "show");
        intent.putExtra("name", name);
        startService(intent);
    }
}
