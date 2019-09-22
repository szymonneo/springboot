package com.szymon.secondweekhw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("Start")
class ShopStart {

    private Basket basket;

    @Autowired
    public ShopStart(Basket basket) {
        this.basket = basket;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showTotalCost() {
        System.out.println("Total cost = " + basket.totalCost());
    }
}
