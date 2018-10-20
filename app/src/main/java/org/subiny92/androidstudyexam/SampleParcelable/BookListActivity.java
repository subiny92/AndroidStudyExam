package org.subiny92.androidstudyexam.SampleParcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.subiny92.androidstudyexam.R;
import org.subiny92.androidstudyexam.SampleParcelable.data.BookData;

import java.util.ArrayList;

/**
 * Created by Dev.Dec on 2018-10-21
 */
public class BookListActivity extends AppCompatActivity {

    private ArrayList<BookData> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        array = bundle.getParcelableArrayList(ParcelableActivity.KEY_BOOKINFO);
        ListView list = (ListView) findViewById(R.id.list);
        BookAdapter bookAdapter = new BookAdapter();
        list.setAdapter(bookAdapter);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("name", "BookListActivity");
        setResult(RESULT_OK, intent);
        finish();
    }

    class BookAdapter extends BaseAdapter {

        public BookAdapter() {}

        @Override
        public int getCount() {
            return array.size();
        }

        @Override
        public Object getItem(int i) {
            return array.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if (view == null) {
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                view = layoutInflater.inflate(R.layout.list_book, viewGroup, false);
            }

            TextView tv_id = (TextView) view.findViewById(R.id.tv_id);
            tv_id.setText(String.format("번호 : %d", array.get(i).getId()));
            TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
            tv_title.setText(String.format("제목 : %s", array.get(i).getTitle()));
            TextView tv_author = (TextView) view.findViewById(R.id.tv_author);
            tv_author.setText(String.format("저자 : %s", array.get(i).getAuthor()));
            TextView tv_publisher = (TextView) view.findViewById(R.id.tv_publisher);
            tv_publisher.setText(String.format("발행사 : %s", array.get(i).getPublisher()));
            TextView tv_price = (TextView) view.findViewById(R.id.tv_price);
            tv_price.setText(String.format("가격 : %d", array.get(i).getPrice()));

            return view;
        }
    }
}

