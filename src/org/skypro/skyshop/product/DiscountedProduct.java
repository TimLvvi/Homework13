package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int percentageDiscount;
    private int finalPrice;

    public DiscountedProduct(String name, int basePrice, int percentageDiscount) {
        super(name);
        this.basePrice = basePrice;
        this.percentageDiscount = percentageDiscount;
    }

    @Override
    public int getPrice() {
        finalPrice = basePrice - basePrice * percentageDiscount * 100 / 10000;
        return finalPrice;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return name + ": " + finalPrice
                + "(c учетом скидки " + percentageDiscount + "%)";
    }
}
