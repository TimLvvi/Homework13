package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private List<Product> basket = new LinkedList<>();


    //Метод добавления продукта в корзину: метод принимает в себя продукт и ничего не возвращает.
    public void addBasket(Product addProduct) {
        basket.add(addProduct);
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
        basket.clear();
    }


    public List<Product> deleteProductFromBasket(String nameProductDelete) {
        List<Product> deleteProduct = new LinkedList<>();

        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product element = iterator.next();
            if (nameProductDelete.equals(element.getName())) {
                deleteProduct.add(element);
                iterator.remove();
            }
        }
        if (deleteProduct.isEmpty()) {
            System.out.println("Список пуст");
        }
        return deleteProduct;
    }

    @Override
    public String toString() {
        return "ProductBasket " + basket;
    }
}




