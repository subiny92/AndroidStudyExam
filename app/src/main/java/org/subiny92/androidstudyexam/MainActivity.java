package org.subiny92.androidstudyexam;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.subiny92.androidstudyexam.SampleService.ServiceMainActivity;

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
        addArray("SampleService", SampleType.Service);
        addArray("SampleBroadCastReceiver", SampleType.BroadCastReceiver);
        addArray("SampleTouchEvent", SampleType.TouchEvent);
    }

    private void addArray(String projectName, SampleType type) {
        array.add(new ResSampleData(projectName, type));
    }

    @Override
    public void onItemClicked(int position) {
        SampleType type = array.get(position).getType();
        Intent intent = null;
        if (type == SampleType.ConfiguringScreensWithJava){}
        else if (type == SampleType.Service) {
            intent = new Intent(MainActivity.this, ServiceMainActivity.class);
        }

        startActivity(intent);
    }

    class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
        private OnSampleItemClickListener onSampleItemClickListener;

        public void setOnSampleItemClickListener(OnSampleItemClickListener onSampleItemClickListener) {
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
