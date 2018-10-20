package org.subiny92.androidstudyexam.SampleOrientation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.subiny92.androidstudyexam.R;

public class OrientationActivity extends AppCompatActivity {

    private String name;
    private EditText et_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation);

        Log("onCreate() 호출됨");

        et_msg = (EditText) findViewById(R.id.et_msg);
        findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = et_msg.getText().toString();
                Toast.makeText(OrientationActivity.this, "입력된 값을 변수에 저장했습니다 : " + name, Toast.LENGTH_SHORT).show();
            }
        });

        if (savedInstanceState != null) {
            String name = savedInstanceState.getString("data");
            Toast.makeText(this, "값을 복원했습니다 : " + name, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log("onStart() 호출됨");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log("onResume() 호출됨");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log("onRestart() 호출됨");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log("onStop() 호출됨");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log("onDestroy() 호출됨");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log("onPause() 호출됨");
    }

    void Log(String message) {
        Log.d("===", message);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log("onSaveInstance() 호출됨");
        outState.putString("data", name);
    }
}
