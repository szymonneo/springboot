package com.szymon.secondweekhw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("Pro")
@ConfigurationProperties(prefix = "cost-manipulation")
class ShopPro {

    private Basket basket;
    private int VAT;
    private int discount;

    @Autowired
    public ShopPro(Basket basket) {
        this.basket = basket;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showTotalCost() {
        System.out.println("Total cost = " + basket.totalCost());
        System.out.printf("Total cost with VAT = %.2f %n", basket.totalCost() + basket.totalCost() * VAT / 100);
        System.out.printf("Total cost with VAT and Discount = %.2f %n", basket.totalCost() + basket.totalCost() * VAT / 100 - discount);
    }

    public void setVAT(int VAT) {
        this.VAT = VAT;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
