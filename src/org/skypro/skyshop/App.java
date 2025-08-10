package org.skypro.skyshop;

import org.skypro.skyshop.articlesProducts.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFoundException;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Product product1 = new SimpleProduct("хлеб", 130);
        Product product2 = new DiscountedProduct("батон", 120, 40);
        Product product3 = new FixPriceProduct("масло");
        Product product4 = new DiscountedProduct("шоколад", 160, 50);
        Product product5 = new SimpleProduct("чипсы", 200);
        Product product6 = new SimpleProduct("жвачка", 40);


        ProductBasket productBasket = new ProductBasket();

        //1.Добавление продукта в корзину.
        productBasket.addBasket(product1);
        productBasket.addBasket(product2);
        productBasket.addBasket(product3);
        productBasket.addBasket(product4);
        productBasket.addBasket(product5);
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
        boolean productAvailabilityChips = productBasket.findProductName("хлеб");
        System.out.println();

//        7.Очистка корзины.
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


        Article article1 = new Article("что такое хлеб и почему хлеб вкусный", "хлеб — пищевой продукт, получаемый выпечкой разрыхлённого посредством дрожжей или закваски теста");
        Article article2 = new Article("польза шоколада", " шоколад изготавливается из какао-бобов, которые являются источником полезных веществ");
        Article article3 = new Article("чипсы и их состав", "чипсы могут изготавливать из тонких ломтиков картофеля или из сухого картофельного пюре в виде хлопьев, крупы или гранул");

        //проверка
        System.out.println(product1.getStringRepresentation());
        System.out.println(article1.getStringRepresentation());
        System.out.println();

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        searchEngine.add(product6);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        //проверка
        System.out.println(searchEngine.toString());
        System.out.println();


        // Тестируем поиск
        System.out.println("Результаты поиска по 'хлеб':");
        System.out.println(searchEngine.search("хлеб"));
        System.out.println();

        System.out.println("Результаты поиска по 'шоколад':");
        System.out.println(searchEngine.search("шоколад"));
        System.out.println();

        System.out.println("Результаты поиска по 'чипсы':");
        System.out.println(searchEngine.search("чипсы"));
        System.out.println();

        //Демонстрация проверки данных в классе main
        try {
            Product product7 = new SimpleProduct(" ", 2000);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        try {
            Product product8 = new SimpleProduct("курица филе", 0);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        try {
            Product product9 = new DiscountedProduct("филе ментая", 600, 120);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();


        // ищем самый подходящий продукт
        try {
            System.out.println(searchEngine.findBestResult("хлеб"));
        } catch (BestResultNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();

        try {
            System.out.println(searchEngine.findBestResult("леска"));
        } catch (BestResultNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();


        ProductBasket productBasket1 = new ProductBasket();

        //1.Добавление продукта в корзину.
        productBasket1.addBasket(product1);
        productBasket1.addBasket(product2);
        productBasket1.addBasket(product3);
        productBasket1.addBasket(product4);
        productBasket1.addBasket(product5);
        productBasket1.addBasket(product3);
        productBasket1.addBasket(product6);

        productBasket1.printBasket();
        System.out.println();


        //Удалить существующий продукт из корзины.
         List<Product> deleteProductOil = productBasket1.deleteProductFromBasket("масло");
        System.out.println();

        //Вывести удаленные продукты на экран.
        System.out.println(deleteProductOil);
        System.out.println();

        //Вывести содержимое корзины с помощью метода printBacket
        productBasket1.printBasket();
        System.out.println();


//        Удалить несуществующий продукт.
//        Проверить, что список удаленных продуктов пустой и вывести сообщение “Список пуст”.
        productBasket1.deleteProductFromBasket("огурец");
        System.out.println();

        //Вывести содержимое корзины на экран.
        System.out.println(productBasket1);
        System.out.println();
    }
}