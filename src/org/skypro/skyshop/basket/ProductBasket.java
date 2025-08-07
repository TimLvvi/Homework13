package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private Product[] basket = new Product[5];


    //Метод добавления продукта в корзину: метод принимает в себя продукт и ничего не возвращает.
    public void addBasket(Product addProduct) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = addProduct;
                return;
            }

        }
        System.out.println("Товар " + addProduct.getName() + " не добавлен в корзину. Корзина забита.");
    }


    //Метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    public int sumProductBasket() {
        int sum = 0;
        for (Product product : basket) {
            if (product != null) {
                sum = sum + product.getPrice();
            }
        }
        return sum;
    }

    //Метод для подсчета количества специальных товаров
    public int countSpecialProduct() {
        int count = 0;
        for (Product product : basket) {
            if (product != null) {
                if (product.isSpecial() == true) {
                    count = count + 1;
                }

            }
        }
        return count;
    }


    //Метод, который печатает содержимое корзины: метод ничего не принимает и не возвращает, но печатает в консоль сообщение вида:
    //<имя продукта>: <стоимость>
    //<имя продукта>: <стоимость>
    //<имя продукта>: <стоимость>
    //Итого: <общая стоимость корзины>
    //Специальных товаров: <Количество специальных товаров>
    public void printBasket() {
            int sum = sumProductBasket();
            if (sum == 0) {
                System.out.println("корзина пустая");
                return;
            }

            for (Product product : basket) {
                if (product != null) {
                    System.out.println(product.toString());
                }
            }
        System.out.println("Итого: " + sum);
        System.out.println("Специальных товаров: " + countSpecialProduct());
    }


    //Метод, проверяющий продукт в корзине по имени: метод принимает в себя строку имени и возвращает boolean в зависимости от того, есть продукт в корзине или его нет.
    public boolean findProductName(String productName) {
        int sum = sumProductBasket();
        for (Product product : basket) {
            if (sum == 0) {
                System.out.println(productName + " нет в корзине, корзина пустая");
                return false;

            }
        }
        for (Product product : basket) {
            if (product.getName().equals(productName) == true) {
                System.out.println(productName + " есть в корзине");
                return true;

            }
        }
        System.out.println(productName + " нет в корзине");
        return false;
    }


    //Метод очистки корзины: метод ничего не принимает и очищает массив, проставляя всем его элементам null

    public void cleanBasket() {
        for (int i = 0; i < basket.length; i++) {
            basket[i] = null;
        }
    }
}




