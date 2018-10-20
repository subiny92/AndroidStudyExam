package org.subiny92.androidstudyexam;

public enum SampleType {
    ConfiguringScreensWithJava(0), Service(1), BroadCastReceiver(2),TouchEvent(3);

    private int typeNumber;

    SampleType(int i) {
        typeNumber = i;
    }

    public int getTypeNumber() {
        return typeNumber;
    }
}
