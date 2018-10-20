package org.subiny92.androidstudyexam.SampleOrientation2;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.subiny92.androidstudyexam.R;

public class Orientation2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orientation2);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            // 가로
            showToast("ORIENTATION_LANDSCAPE");
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // 세로
            showToast("ORIENTATION_PORTRAIT");
        }
    }

    void showToast(String message) {
        Toast.makeText(this, "방향 : " + message, Toast.LENGTH_SHORT).show();
    }
}
