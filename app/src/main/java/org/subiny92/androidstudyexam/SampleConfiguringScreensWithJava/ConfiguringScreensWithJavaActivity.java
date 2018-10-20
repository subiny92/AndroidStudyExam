package org.subiny92.androidstudyexam.SampleConfiguringScreensWithJava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import org.subiny92.androidstudyexam.R;

public class ConfiguringScreensWithJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuring_screens_with_java);

        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mainLayout.setLayoutParams(params);

        Button button = new Button(this);
        button.setText("button01");
        button.setLayoutParams(params);

        mainLayout.addView(button);

        LinearLayout secondLayout = new LinearLayout(this);
        secondLayout.setOrientation(LinearLayout.HORIZONTAL);
        secondLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        Button button1 = new Button(this);
        button1.setText("1");
        button1.setLayoutParams(param);
        Button button2 = new Button(this);
        button2.setText("2");
        button2.setLayoutParams(param);
        Button button3 = new Button(this);
        button3.setText("3");
        button3.setLayoutParams(param);

        secondLayout.addView(button1, 0);
        secondLayout.addView(button2, 1);
        secondLayout.addView(button3, 2);

        mainLayout.addView(secondLayout);

        setContentView(mainLayout);
    }
}
