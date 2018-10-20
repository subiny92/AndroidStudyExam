package org.subiny92.androidstudyexam.SampleService;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.subiny92.androidstudyexam.R;

public class ServiceMainActivity extends AppCompatActivity {

    private static final String TAG = "MyService";
    private EditText et_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_main);
        Log.d(TAG, "ServiceMainActivity onCreate()");
        et_service = (EditText) findViewById(R.id.et_service);

        Intent intent = getIntent();
        processIntent(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.d(TAG, "ServiceMainActivity onNewIntent()");
        processIntent(intent);
//        super.onNewIntent(intent);
    }

    public void ServiceClicked(View view) {
        String name = et_service.getText().toString();
        Intent intent = new Intent(ServiceMainActivity.this, MyService.class);
        intent.putExtra("command", "show");
        intent.putExtra("name", name);
        startService(intent);
    }

    private void processIntent(Intent intent) {
        if (intent != null) {
            String command = intent.getStringExtra("command");
            String name = intent.getStringExtra("name");

            Toast.makeText(this, "command : " + command + ", name : " + name, Toast.LENGTH_SHORT).show();
        }
    }

}
