package com.example.inheritance;

public class DVD extends LibraryItem{
    private int duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public DVD(int itemID, String author, String title, int duration) {
        super(itemID, author, title);
        this.duration = duration;
    }
}
