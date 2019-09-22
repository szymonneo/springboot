package com.szymon.secondweekhw;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
class Basket {

    private List<Product> productList;

    public Basket() {
        productList = new ArrayList<>();
        addProduct("Product1", generateRandomNumberBetween50And300());
        addProduct("Product2", generateRandomNumberBetween50And300());
        addProduct("Product3", generateRandomNumberBetween50And300());
        addProduct("Product4", generateRandomNumberBetween50And300());
        addProduct("Product5", generateRandomNumberBetween50And300());
    }

    private int generateRandomNumberBetween50And300() {
        return ThreadLocalRandom.current().nextInt(50, 301);
    }

    private void addProduct(String name, int price) {
        productList.add(new Product(name, price));
    }

    @EventListener(ApplicationReadyEvent.class)
    double totalCost() {
        int totalCost = 0;
        for (Product product : productList) {
            totalCost += product.getPrice();
        }
        return totalCost;
    }
}
