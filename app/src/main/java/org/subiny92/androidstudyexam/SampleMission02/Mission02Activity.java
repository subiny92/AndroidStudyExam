package org.subiny92.androidstudyexam.SampleMission02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.subiny92.androidstudyexam.R;

import java.text.Format;

public class Mission02Activity extends AppCompatActivity {

    private EditText et_message;
    private TextView tv_line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission02);

        et_message = (EditText) findViewById(R.id.et_message);
        et_message.addTextChangedListener(textWatcher);
        tv_line = (TextView) findViewById(R.id.tv_line);
        tv_line.setText("0 / 80 바이트");

        findViewById(R.id.btn_summit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = et_message.getText().toString();
                Toast.makeText(Mission02Activity.this, "message : " + message, Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_message.setText(null);
                tv_line.setText("0 / 80 바이트");
            }
        });
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            String line = String.format("%d / 80 바이트", s.length());
            tv_line.setText(line);
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() >= 80) {
                Toast.makeText(Mission02Activity.this, " 최대 80자리 까지 입력 가능합니다.", Toast.LENGTH_SHORT).show();
            }

            String line = String.format("%d / 80 바이트", s.length());
            tv_line.setText(line);

        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };
}
