package org.subiny92.androidstudyexam.SampleLayoutInflater;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import org.subiny92.androidstudyexam.R;

public class LayoutInflaterActivity extends AppCompatActivity {

    private LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_inflater);

        container = (LinearLayout) findViewById(R.id.container);
        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.activity_sub, container, true);

                CheckBox chk = container.findViewById(R.id.chk);
                chk.setText("로딩되었어요.");
            }
        });
    }
}
