package org.subiny92.androidstudyexam;

public class ResSampleData {
    private String title;
    private SampleType type;

    public ResSampleData(String title, SampleType type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public SampleType getType() {
        return type;
    }
}
