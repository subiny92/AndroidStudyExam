package org.subiny92.androidstudyexam.SampleSlideAnimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import org.subiny92.androidstudyexam.R;

public class SlideAnimationActivity extends AppCompatActivity {

    private boolean isPageOpen = false; // 페이지가 오픈했는지 여부 true : Open, false : Close
    private Animation translateLeftAnim;
    private Animation translateRightAnim;
    private LinearLayout page;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_animation);

        page = (LinearLayout) findViewById(R.id.page);
        button = (Button) findViewById(R.id.button);

        translateLeftAnim = AnimationUtils.loadAnimation(this, R.anim.left);
        translateRightAnim = AnimationUtils.loadAnimation(this, R.anim.right);

        SlidePageAnimationListener slidePageAnimationListener = new SlidePageAnimationListener();
        translateLeftAnim.setAnimationListener(slidePageAnimationListener);
        translateRightAnim.setAnimationListener(slidePageAnimationListener);
    }

    public void buttonOpenNClose(View view) {
        if (isPageOpen) {
            page.startAnimation(translateRightAnim);
        } else {
            page.setVisibility(View.VISIBLE);
            page.startAnimation(translateLeftAnim);
        }
    }

    class SlidePageAnimationListener implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if (isPageOpen) {
                isPageOpen =false;
                page.setVisibility(View.INVISIBLE);
                button.setText("Open");
            } else {
                isPageOpen = true;
                button.setText("Close");
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
