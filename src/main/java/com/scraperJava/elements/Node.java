package com.scraperJava.elements;


import java.nio.file.Files;

/**
 * Created by Ilya Loshchinin on 22.09.2017.
 */
public class Node {
    private long ID;
    private String price;
    private int countOfRooms;
    private int area;
    private Files photo;
    private String address;
    private int level;

    public Node(long ID, String price, int countOfRooms, int area, Files photo, String address, int level) {
        this.ID = ID;
        this.price = price;
        this.countOfRooms = countOfRooms;
        this.area = area;
        this.photo = photo;
        this.address = address;
        this.level = level;
    }

    public long getID() {
        return ID;
    }

    public String getPrice() {
        return price;
    }

    public int getCountOfRooms() {
        return countOfRooms;
    }

    public int getArea() {
        return area;
    }

    public Files getPhoto() {
        return photo;
    }

    public String getAddress() {
        return address;
    }

    public int getLevel() {
        return level;
    }
}
