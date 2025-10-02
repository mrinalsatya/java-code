package com.example.inheritance;

public class LibraryItem {
    private int itemID;
    private String title;
    private String author;

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LibraryItem(int itemID, String author, String title) {
        this.itemID = itemID;
        this.author = author;
        this.title = title;
    }

    public void checkout(){
        System.out.println("Base checkout");
    }

    public void returnItem(){
        System.out.println("Base return item.");
    }
}
