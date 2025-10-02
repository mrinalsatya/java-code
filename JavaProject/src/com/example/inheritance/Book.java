package com.example.inheritance;

public class Book extends LibraryItem {
    private String ISBN;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Book(int itemID, String author, String title, String ISBN) {
        super(itemID, author, title);
        this.ISBN = ISBN;
    }

    @Override
    public void checkout() {
        System.out.println("Book checkout");
    }
}
