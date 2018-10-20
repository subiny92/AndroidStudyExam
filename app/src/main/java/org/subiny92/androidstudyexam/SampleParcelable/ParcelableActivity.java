package org.subiny92.androidstudyexam.SampleParcelable;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.subiny92.androidstudyexam.R;
import org.subiny92.androidstudyexam.SampleParcelable.data.BookData;
import org.subiny92.androidstudyexam.SampleParcelable.data.SimpleData;

import java.util.ArrayList;

public class ParcelableActivity extends AppCompatActivity {

    public static final String KEY_SAMPLE = "sample";
    public static final String KEY_BOOKINFO = "bookInfo";
    public static final int REQUEST_CODE_MENU = 0x01;
    public static final int REQUEST_CODE_BOOK_LIST = REQUEST_CODE_MENU + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);

        findViewById(R.id.btn_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParcelableActivity.this, MenuActivity.class);
                SimpleData data = new SimpleData(100, "Hello Android~!!");

                intent.putExtra(KEY_SAMPLE, data);
                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });

        findViewById(R.id.btn_booklist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParcelableActivity.this, BookListActivity.class);
                intent.putParcelableArrayListExtra(KEY_BOOKINFO, getBookList());
                startActivityForResult(intent, REQUEST_CODE_BOOK_LIST);
            }
        });
    }

    private ArrayList<BookData> getBookList() {
        ArrayList<BookData> bookList = new ArrayList<>();
        bookList.add(new BookData(11111, "개미", "베르나르베르베르", "한빛미디어", 25000));
        bookList.add(new BookData(11112, "잠", "베르나르베르베르", "한빛미디어", 20000));
        bookList.add(new BookData(11113, "라임오렌지나무", "라임", "라임미디어", 15000));
        bookList.add(new BookData(11114, "안드로이드", "DEC", "디셈미디어", 35000));
        bookList.add(new BookData(11115, "스위프트", "DEC", "디셈미디어", 24000));
        bookList.add(new BookData(11116, "JSP", "DEC", "디셈미디어", 20000));

        return bookList;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_MENU) {
            if (resultCode == RESULT_OK) {
                String message = data.getStringExtra("name");
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == REQUEST_CODE_BOOK_LIST) {
            if (resultCode == RESULT_OK) {
                String message = data.getStringExtra("name");
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
