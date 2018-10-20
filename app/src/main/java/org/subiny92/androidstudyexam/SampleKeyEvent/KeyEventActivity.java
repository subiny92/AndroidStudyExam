package org.subiny92.androidstudyexam.SampleKeyEvent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import org.subiny92.androidstudyexam.R;

public class KeyEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode, event);

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(this, "시스템[BACK] 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
