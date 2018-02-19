package com.yangs.xml.bean;

/**
 * Created by Ytadpole on 2018/2/19.
 */
public class Book {
    private String id;
    private String att;

    private String name;
    private String author;
    private String date;
    private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAtt() {
        return att;
    }

    public void setAtt(String att) {
        this.att = att;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", att='" + att + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
