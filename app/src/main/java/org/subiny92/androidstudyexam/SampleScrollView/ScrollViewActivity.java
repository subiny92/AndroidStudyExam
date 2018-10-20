package org.subiny92.androidstudyexam.SampleScrollView;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import org.subiny92.androidstudyexam.R;

public class ScrollViewActivity extends AppCompatActivity {

    private ScrollView scv;
    private ImageView iv;
    private BitmapDrawable bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);

        scv = (ScrollView) findViewById(R.id.scv);
        scv.setHorizontalScrollBarEnabled(true);
        iv = (ImageView) findViewById(R.id.iv);

        Resources resources = getResources();
        bitmap = (BitmapDrawable) resources.getDrawable(R.drawable.image01);
        int width = bitmap.getIntrinsicWidth();
        int height = bitmap.getIntrinsicHeight();

        iv.setImageDrawable(bitmap);
        iv.getLayoutParams().width = width;
        iv.getLayoutParams().height = height;
    }

    public void imageChanged(View view) {
        changeImage();
    }

    private void changeImage() {
        Resources resources = getResources();
        bitmap = (BitmapDrawable) resources.getDrawable(R.drawable.image02);
        int width = bitmap.getIntrinsicWidth();
        int height = bitmap.getIntrinsicHeight();

        iv.setImageDrawable(bitmap);
        iv.getLayoutParams().width = width;
        iv.getLayoutParams().height = height;
    }
}
