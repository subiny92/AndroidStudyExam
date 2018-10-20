package org.subiny92.androidstudyexam.SampleParcelable.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dev.Dec on 2018-10-21
 */
public class BookData implements Parcelable {

    private int id; // 책 번호
    private String title; // 책 제목
    private String author; // 책 저자
    private String publisher; // 책 발행자
    private int price; // 책 가격

    public BookData (int id, String title, String author, String publisher, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    protected BookData(Parcel in) {
        id = in.readInt();
        title = in.readString();
        author = in.readString();
        publisher = in.readString();
        price = in.readInt();
    }

    public static final Creator<BookData> CREATOR = new Creator<BookData>() {
        @Override
        public BookData createFromParcel(Parcel in) {
            return new BookData(in);
        }

        @Override
        public BookData[] newArray(int size) {
            return new BookData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(author);
        parcel.writeString(publisher);
        parcel.writeInt(price);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPrice() {
        return price;
    }
}
