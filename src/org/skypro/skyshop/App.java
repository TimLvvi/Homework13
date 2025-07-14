package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product("хлеб", 120);
        Product product2 = new Product("батон", 100);
        Product product3 = new Product("масло", 250);
        Product product4 = new Product("шоколад", 150);
        Product product5 = new Product("чипсы", 200);
        Product product6 = new Product("жвачка", 40);


        ProductBasket productBasket = new ProductBasket();

        //1.Добавление продукта в корзину.
        productBasket.addBasket(product1);
        productBasket.addBasket(product2);
        productBasket.addBasket(product3);
        productBasket.addBasket(product4);
        productBasket.addBasket(product5);
        System.out.println();

        //2.Добавление продукта в заполненную корзину, в которой нет свободного места.
        productBasket.addBasket(product6);
        System.out.println();

        //Получение стоимости корзины.
        int sum = productBasket.sumProductBasket();
        System.out.println("Cумма продуктов в корзине: " + sum);
        System.out.println();

        //3.Печать содержимого корзины с несколькими товарами.
        //4.Получение стоимости корзины с несколькими товарами.
        productBasket.printBasket();
        System.out.println();

        //5.Поиск товара, который есть в корзине.
        //6.Поиск товара, которого нет в корзине.
        boolean productAvailabilityChips = productBasket.findProductName("чипсы");
        System.out.println();

        //7.Очистка корзины.
        productBasket.cleanBasket();

        //8. Печать содержимого пустой корзины.
        productBasket.printBasket();
        System.out.println();

        //9.Получение стоимости пустой корзины.
        int sum1 = productBasket.sumProductBasket();
        System.out.println("Cумма продуктов в корзине: " + sum1);
        System.out.println();

        //10.Поиск товара по имени в пустой корзине.
        boolean productAvailabilityBread = productBasket.findProductName("хлеб");
        System.out.println();
    }
}