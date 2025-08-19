package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> basket = new TreeMap<>();


    //Метод добавления продукта в корзину: метод принимает в себя продукт и ничего не возвращает.
    public void addBasket(Product addProduct) {
        List<Product> products;
        if (!basket.containsKey(addProduct.getName())) {
            products = new LinkedList<>();
            basket.put(addProduct.getName(), products);
        } else {
            products = basket.get(addProduct.getName());
        }
        products.add(addProduct);

    }


    //Метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    public int sumProductBasket() {
        int sum = 0;
        for (List<Product> basket : basket.values()) {
            for (Product product : basket) {
                if (product != null) {
                    sum = sum + product.getPrice();
                }
            }
        }
        return sum;
    }

    //Метод для подсчета количества специальных товаров
    public int countSpecialProduct() {
        int count = 0;
        for (List<Product> basket : basket.values()) {
            for (Product product : basket) {
                if (product != null & product.isSpecial() == true) {
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

        for (List<Product> basket : basket.values())
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

        if (sum == 0) {
            System.out.println(productName + " нет в корзине, корзина пустая");
            return false;
        }

        if (basket.containsKey(productName)) {
            System.out.println(productName + " есть в корзине");
            return true;
        }

        System.out.println(productName + " нет в корзине");
        return false;
    }


    //Метод очистки корзины: метод ничего не принимает и очищает массив, проставляя всем его элементам null

    public void cleanBasket() {
        basket.clear();
    }

    // метод удалющий продукт из корзины.
    public List<Product> deleteProductFromBasket(String nameProductDelete) {
        List<Product> deleteProduct = new LinkedList<>();

        if (!basket.containsKey(nameProductDelete)) {
            System.out.println(nameProductDelete + " в списке не найден");
        }

        if (basket.containsKey(nameProductDelete)) {
            deleteProduct = basket.get(nameProductDelete);
            basket.remove(nameProductDelete);
        }

        if (basket.isEmpty()) {
            System.out.println("Список пуст");
        }
        return deleteProduct;
    }


//    public List<Product> deleteProductFromBasket(String nameProductDelete) {
//        List<Product> deleteProduct = new LinkedList<>();
//
//        Iterator<Product> iterator = basket.iterator();
//        while (iterator.hasNext()) {
//            Product element = iterator.next();
//            if (nameProductDelete.equals(element.getName())) {
//                deleteProduct.add(element);
//                iterator.remove();
//            }
//        }
//        if (deleteProduct.isEmpty()) {
//            System.out.println("Список пуст");
//        }
//        return deleteProduct;
//    }

    @Override
    public String toString() {
        return "ProductBasket " + basket;
    }
}




