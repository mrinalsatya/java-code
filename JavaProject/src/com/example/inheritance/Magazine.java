package com.example.inheritance;

public class Magazine extends LibraryItem{
    private String issueNumber;

    public Magazine(int itemID, String author, String title, String issueNumber) {
        super(itemID, author, title);
        this.issueNumber = issueNumber;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }
}
