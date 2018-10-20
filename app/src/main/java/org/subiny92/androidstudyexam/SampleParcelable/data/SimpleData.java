package org.subiny92.androidstudyexam.SampleParcelable.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dev.Dec on 2018-10-21
 */
public class SimpleData implements Parcelable {

    private int number;
    private String message;

    public SimpleData(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public SimpleData(Parcel in) {
        this.number = in.readInt();
        this.message = in.readString();
    }

    public static final Creator<SimpleData> CREATOR = new Creator<SimpleData>() {
        @Override
        public SimpleData createFromParcel(Parcel in) {
            return new SimpleData(in);
        }

        @Override
        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(number);
        parcel.writeString(message);
    }

    public int getNumber() {
        return number;
    }

    public String getMessage() {
        return message;
    }
}
