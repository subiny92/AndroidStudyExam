package org.subiny92.androidstudyexam.SampleParcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.subiny92.androidstudyexam.R;
import org.subiny92.androidstudyexam.SampleParcelable.data.SimpleData;

/**
 * Created by Dev.Dec on 2018-10-21
 */
public class MenuActivity extends AppCompatActivity {

    private TextView tv_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tv_message = (TextView) findViewById(R.id.tv_message);
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name", "menuActivity");

                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Intent intent = getIntent();
        processIntent(intent);
    }

    private void processIntent(Intent intent) {
        Bundle bundle = intent.getExtras();
        SimpleData data = bundle.getParcelable(ParcelableActivity.KEY_SAMPLE);

        tv_message.setText("전달받은 데이터\nNumber : " + data.getNumber() +
                "\nMessage : " + data.getMessage());
    }

}
