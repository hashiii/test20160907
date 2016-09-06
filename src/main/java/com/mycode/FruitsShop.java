package com.mycode;

import java.util.ArrayList;
import java.util.List;

public class FruitsShop {

    private static final FruitsShop shop = new FruitsShop();
    private final List<Fruits> fruitsList;

    private FruitsShop() {
        fruitsList = new ArrayList<>();
    }

    public static FruitsShop getShop() {
        return shop;
    }

    public List<Fruits> getFruitsList() {
        return fruitsList;
    }

    public void addFruits(Fruits fruits) {
        fruitsList.add(fruits);
    }

    public String getMessage(Fruits fruits) {
        return fruits.getName() + "は" + fruits.getPrice() + "円です";
    }
}
