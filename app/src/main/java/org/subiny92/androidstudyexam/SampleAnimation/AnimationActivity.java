package org.subiny92.androidstudyexam.SampleAnimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import org.subiny92.androidstudyexam.R;

public class AnimationActivity extends AppCompatActivity {

    private TextView tv_animation;
    private Animation flow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        tv_animation = (TextView) findViewById(R.id.tv_animation);
        flow = AnimationUtils.loadAnimation(this, R.anim.flow);
        flow.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(AnimationActivity.this, "애니메이션 종료됨", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void btnStart(View view) {
        tv_animation.startAnimation(flow);
    }
}
