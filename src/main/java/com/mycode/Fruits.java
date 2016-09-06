package com.mycode;

public class Fruits {

    private final String name;
    private final int price;

    public Fruits(String n, int p) {
        name = n;
        price = p;
    }

    public void show() {
        System.out.println(name + "は" + price + "円です");
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
