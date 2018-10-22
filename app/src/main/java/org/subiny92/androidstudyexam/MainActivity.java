package org.subiny92.androidstudyexam;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import org.subiny92.androidstudyexam.SampleAnimation.AnimationActivity;
import org.subiny92.androidstudyexam.SampleBoardCastReceiver.BoardCastReceiverActivity;
import org.subiny92.androidstudyexam.SampleConfiguringScreensWithJava.ConfiguringScreensWithJavaActivity;
import org.subiny92.androidstudyexam.SampleFocusEvent.FocusEventActivity;
import org.subiny92.androidstudyexam.SampleGestureDetector.GestureDetectorActivity;
import org.subiny92.androidstudyexam.SampleKeyEvent.KeyEventActivity;
import org.subiny92.androidstudyexam.SampleLayoutInflater.LayoutInflaterActivity;
import org.subiny92.androidstudyexam.SampleMission01.Mission01Activity;
import org.subiny92.androidstudyexam.SampleMission02.Mission02Activity;
import org.subiny92.androidstudyexam.SampleOrientation.OrientationActivity;
import org.subiny92.androidstudyexam.SampleOrientation2.Orientation2Activity;
import org.subiny92.androidstudyexam.SamplePDFView.PDFViewActivity;
import org.subiny92.androidstudyexam.SampleParcelable.ParcelableActivity;
import org.subiny92.androidstudyexam.SampleScrollView.ScrollViewActivity;
import org.subiny92.androidstudyexam.SampleSeekBar.SeekBarActivity;
import org.subiny92.androidstudyexam.SampleService.ServiceMainActivity;
import org.subiny92.androidstudyexam.SampleSlideAnimation.SlideAnimationActivity;
import org.subiny92.androidstudyexam.SampleToast.ToastActivity;
import org.subiny92.androidstudyexam.SampleTouchEvent.TouchEventActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnSampleItemClickListener{

    private ArrayList<ResSampleData> array = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        MainAdapter mainAdapter = new MainAdapter();
        mainAdapter.setOnSampleItemClickListener(this);
        rv.setAdapter(mainAdapter);

    }


    private void init() {
        addArray("SampleConfiguringScreensWithJava", SampleType.ConfiguringScreensWithJava);
        addArray("SampleScrollView", SampleType.ScrollView);
        addArray("SampleMission01", SampleType.Mission01);
        addArray("SampleMission02", SampleType.Mission02);
        addArray("SampleLayoutInflater", SampleType.LayoutInflater);
        addArray("SamplePDFView", SampleType.PDFView);
        addArray("SampleParcelable", SampleType.Parcelable);
        addArray("SampleService", SampleType.Service);
        addArray("SampleBroadCastReceiver", SampleType.BroadCastReceiver);
        addArray("SampleTouchEvent", SampleType.TouchEvent);
        addArray("SampleGestureDetector", SampleType.GestureDetector);
        addArray("SampleKeyEvent", SampleType.KeyEvent);
        addArray("SampleFocusEvent", SampleType.FocusEvent);
        addArray("SampleOrientation", SampleType.Orientation);
        addArray("SampleOrientation2", SampleType.Orientation2);
        addArray("SampleToast", SampleType.Toast);
        addArray("SampleSeekBar", SampleType.SeekBar);
        addArray("SampleAnimation", SampleType.Animation);
        addArray("SampleSlideAnimation", SampleType.SlideAnimation);

    }

    private void addArray(String projectName, SampleType type) {
        array.add(new ResSampleData(projectName, type));
    }

    @Override
    public void onItemClicked(int position) {
        SampleType type = array.get(position).getType();
        Intent intent = null;
        if (type == SampleType.ConfiguringScreensWithJava){
            intent = new Intent(MainActivity.this, ConfiguringScreensWithJavaActivity.class);
        }
        else if (type == SampleType.ScrollView) {
            intent = new Intent(MainActivity.this, ScrollViewActivity.class);
        }
        else if (type == SampleType.Mission01) {
            intent = new Intent(MainActivity.this, Mission01Activity.class);
        }
        else if (type == SampleType.Mission02) {
            intent = new Intent(MainActivity.this, Mission02Activity.class);
        }
        else if (type == SampleType.LayoutInflater) {
            intent = new Intent(MainActivity.this, LayoutInflaterActivity.class);
        }
        else if (type == SampleType.PDFView) {
            intent = new Intent(MainActivity.this, PDFViewActivity.class);
        }
        else if (type == SampleType.Parcelable) {
            intent = new Intent(MainActivity.this, ParcelableActivity.class);
        }
        else if (type == SampleType.Service) {
            intent = new Intent(MainActivity.this, ServiceMainActivity.class);
        }
        else if (type == SampleType.BroadCastReceiver) {
            intent = new Intent(MainActivity.this, BoardCastReceiverActivity.class);
        }
        else if (type == SampleType.TouchEvent) {
            intent = new Intent(MainActivity.this, TouchEventActivity.class);
        }
        else if (type == SampleType.GestureDetector) {
            intent = new Intent(MainActivity.this, GestureDetectorActivity.class);
        }
        else if (type == SampleType.KeyEvent) {
            intent = new Intent(MainActivity.this, KeyEventActivity.class);
        }
        else if (type == SampleType.FocusEvent) {
            intent = new Intent(MainActivity.this, FocusEventActivity.class);
        }
        else if (type == SampleType.Orientation) {
            intent = new Intent(MainActivity.this, OrientationActivity.class);
        }
        else if (type == SampleType.Orientation2) {
            intent = new Intent(MainActivity.this, Orientation2Activity.class);
        }
        else if (type == SampleType.Toast) {
            intent = new Intent(MainActivity.this, ToastActivity.class);
        }
        else if (type == SampleType.SeekBar) {
            intent = new Intent(MainActivity.this, SeekBarActivity.class);
        }
        else if (type == SampleType.Animation) {
            intent = new Intent(MainActivity.this, AnimationActivity.class);
        }
        else if (type == SampleType.SlideAnimation) {
            intent = new Intent(MainActivity.this, SlideAnimationActivity.class);
        }

        if (intent != null) {
            startActivity(intent);
        }
    }

    class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
        private OnSampleItemClickListener onSampleItemClickListener;

        void setOnSampleItemClickListener(OnSampleItemClickListener onSampleItemClickListener) {
            this.onSampleItemClickListener = onSampleItemClickListener;
        }

        MainAdapter(){}

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.list_main, viewGroup, false);
            return new MainViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int i) {
            String contents = array.get(i).getTitle();
            final int pos = i;
            mainViewHolder.tv_contents.setText(contents);
            mainViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onSampleItemClickListener.onItemClicked(pos);
                }
            });
        }

        @Override
        public int getItemCount() {
            return array.size();
        }

        class MainViewHolder extends RecyclerView.ViewHolder {

            TextView tv_contents;

            MainViewHolder(@NonNull View itemView) {
                super(itemView);
                tv_contents = (TextView) itemView.findViewById(R.id.tv_contents);
            }
        }
    }
}
