package org.subiny92.androidstudyexam.SampleToast;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.subiny92.androidstudyexam.R;

public class ToastActivity extends AppCompatActivity {

    private EditText et_xOffset;
    private EditText et_yOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        // 메모리에 객체화 된 xml 파일안에 있는 EditText 위젯의 id 값을 이용하여 참조한다.
        et_xOffset = (EditText) findViewById(R.id.et_xOffset);
        et_yOffset = (EditText) findViewById(R.id.et_yOffset);
    }

    public void btnClicked(View view) {
        Toast toast = Toast.makeText(this, "위치가 바뀐 토스트 메세지입니다.", Toast.LENGTH_SHORT);

        try {
            int xOffset = Integer.parseInt(et_xOffset.getText().toString());
            int yOffset = Integer.parseInt(et_yOffset.getText().toString());

            toast.setGravity(Gravity.TOP, xOffset, yOffset);
            toast.show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "exception : " + e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void btnClicked2(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_view, (ViewGroup) findViewById(R.id.root_view));

        TextView tv_msg = (TextView) layout.findViewById(R.id.tv_message);
        tv_msg.setText("모양을 바꾼 토스트");

        Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public void btnClicked3(View view) {
        Snackbar.make(view, "스낵바입니다.", Snackbar.LENGTH_SHORT).show();
    }
}
