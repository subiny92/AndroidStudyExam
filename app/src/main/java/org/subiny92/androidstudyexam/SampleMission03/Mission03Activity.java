package org.subiny92.androidstudyexam.SampleMission03;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import org.subiny92.androidstudyexam.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Mission03Activity extends AppCompatActivity {

    private EditText et_name;
    private EditText et_age;
    private Button btn_date;

    private SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
    private Calendar currentCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission03);

        et_name = (EditText) findViewById(R.id.et_name);
        et_age = (EditText) findViewById(R.id.et_age);
        btn_date = (Button) findViewById(R.id.btn_date);
        Button btn_save = (Button) findViewById(R.id.btn_save);
        currentCalendar = Calendar.getInstance();

        if (currentCalendar.getTime() != null) {
            String strToday = format.format(currentCalendar.getTime());
            if (strToday != null) {
                btn_date.setText(strToday);
            }
        }

        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Mission03Activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        Calendar c = Calendar.getInstance();
                        c.set(i, i1, i2);
                        String dateFormat = format.format(c.getTime());
                        btn_date.setText(dateFormat);
                    }
                }, currentCalendar.get(Calendar.YEAR), currentCalendar.get(Calendar.MONTH), currentCalendar.get(Calendar.DAY_OF_WEEK));

                datePickerDialog.show();
            }
        });


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_name.getText().toString();
                String age = et_age.getText().toString();
                String date = btn_date.getText().toString();
                String message = String.format("이름 : %s\n나이 : %s\n생년월일 : %s", name, age,date);
                Toast.makeText(Mission03Activity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
