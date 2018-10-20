package org.subiny92.androidstudyexam.SampleMission01;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import org.subiny92.androidstudyexam.R;

public class Mission01Activity extends AppCompatActivity {

    private ImageView iv_up;
    private ImageView iv_down;
    private BitmapDrawable bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission01);

        ScrollView scv_1 = (ScrollView) findViewById(R.id.scv_1);
        scv_1.setHorizontalScrollBarEnabled(true);
        ScrollView scv_2 = (ScrollView) findViewById(R.id.scv_2);
        scv_2.setHorizontalScrollBarEnabled(true);
        iv_up = (ImageView) findViewById(R.id.iv_up);
        iv_down = (ImageView) findViewById(R.id.iv_down);

        changeImage(true);
    }

    private void changeImage(boolean isImageUpPosition) {
        Resources resources = getResources();
        bitmap = (BitmapDrawable) resources.getDrawable(R.drawable.image01);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        if (isImageUpPosition) {
            iv_up.setImageDrawable(bitmap);
            iv_up.getLayoutParams().width = bitmapWidth;
            iv_up.getLayoutParams().height = bitmapHeight;
            iv_down.setImageDrawable(null);
        } else {
            iv_down.setImageDrawable(bitmap);
            iv_down.getLayoutParams().width = bitmapWidth;
            iv_down.getLayoutParams().height = bitmapHeight;
            iv_up.setImageDrawable(null);
        }
    }

    public void buttonUpClicked(View view) {
        changeImage(true);
    }

    public void buttonDownClicked(View view) {
        changeImage(false);
    }
}
