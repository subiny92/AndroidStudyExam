package org.subiny92.androidstudyexam.SampleBoardCastReceiver;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.subiny92.androidstudyexam.R;

public class BoardCastReceiverActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private boolean isWork = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_cast_receiver);

        checkPermission();

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isWork) {
                    finish();
                } else {
                    Toast.makeText(BoardCastReceiverActivity.this, "자신에게 문자를 보내세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Intent intent = getIntent();
        processIntent(intent);
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String [] {Manifest.permission.RECEIVE_SMS}, 0);
            }
            checkPermission();
        }
    }

    private void processIntent(Intent intent) {
        if (intent != null) {
            String sender = intent.getStringExtra("sender");
            String message = intent.getStringExtra("message");
            String date = intent.getStringExtra("date");

            editText1.setText(sender);
            editText2.setText(message);
            editText3.setText(date);
            isWork = true;
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
    }


}
