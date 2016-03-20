/* Домашнее задание к Модулю 7
Найти и описать анти-паттерны в своём коде и предложить вариант их исправления.
Формат описания - комментарии в исходном коде с предложениями их решения.
Решение обсудить с ментором и только ПОСЛЕ этого изменять код.
 */

import java.util.*;

public class Module7 {
    public static void main(String[] args) {
        MusicShop shop = new MusicShop(16, 2, 7);

        Map<String, Integer> order = new HashMap<>();

        order.put("guitar", 7);
        order.put("trumpet", 2);

        try {
            List<MusicalInstrument> orderList = shop.prepareInstruments(order);

            System.out.println();
            System.out.println("order: " + orderList);
            System.out.println("Guitars in shop after order: " + shop.guitars.size());
            System.out.println("Pianos in shop after order: " + shop.pianos.size());
            System.out.println("Trumpets in shop after order: " + shop.trumpets.size());

            order.clear();
            order.put("piano", 1);
            orderList = shop.prepareInstruments(order);
            System.out.println();
            System.out.println("order: " + orderList);
            System.out.println("Guitars in shop after order: " + shop.guitars.size());
            System.out.println("Pianos in shop after order: " + shop.pianos.size());
            System.out.println("Trumpets in shop after order: " + shop.trumpets.size());

            order.clear();
            order.put("piano", 1);
            order.put("guitar", 8);
            order.put("trumpet", 6);
            orderList = shop.prepareInstruments(order);
            System.out.println();
            System.out.println("order: " + orderList);
            System.out.println("Guitars in shop after order: " + shop.guitars.size());
            System.out.println("Pianos in shop after order: " + shop.pianos.size());
            System.out.println("Trumpets in shop after order: " + shop.trumpets.size());

        }catch (UnsupportedOperationException e){
            System.out.println();
            System.out.println(e);
            System.out.println("the order: "+order+" is not executed");
            System.out.println("Guitars in shop after order: " + shop.guitars.size());
            System.out.println("Pianos in shop after order: " + shop.pianos.size());
            System.out.println("Trumpets in shop after order: " + shop.trumpets.size());

        }
    }
}

class MusicalInstrument {}

class Guitar extends MusicalInstrument {}
class Piano extends MusicalInstrument {}
class Trumpet extends MusicalInstrument {}

class MusicShop {
    List<Guitar> guitars;
    List<Piano> pianos;
    List<Trumpet> trumpets;

    MusicShop(int guitars, int pianos, int trumpets) {
        this.guitars = new ArrayList<>();
        this.pianos = new ArrayList<>();
        this.trumpets = new ArrayList<>();

        for (int i = 0; i < guitars; i++) {
            this.guitars.add(new Guitar());
        }
        for (int i = 0; i < pianos; i++) {
            this.pianos.add(new Piano());
        }
        for (int i = 0; i < trumpets; i++) {
            this.trumpets.add(new Trumpet());
        }
    }


    public List<MusicalInstrument> prepareInstruments(Map<String, Integer> order){
        List<MusicalInstrument> orderList = new ArrayList<>();

        int countGuitarsToRemove = 0;
        int countPianosToRemove = 0;
        int countTrumpetsToRemove = 0;

        if (order.isEmpty()) {
            throw new InvalidOrderException();
        } else {
            order.forEach((k, v) -> {
                if (!((k.equals("piano")) || (k.equals("guitar")) || (k.equals("trumpet")))) {   // объявить "piano", "guitar", "trumpet" как строковые переменные в начале метода
                    throw new InvalidKeyOrderException();
                }
            });
        }
        if (order.containsKey("guitar") || order.containsKey("piano") || order.containsKey("trumpet")) { // 1* В коде между 1* *1, 2* *2 и 3* *3 повторяющиеся секции кода которые можно вынести в отдельный метод
            if ((order.containsKey("guitar")) && (order.get("guitar") > 0)) {
                for (int i = 0; i < order.get("guitar"); i++) {
                    orderList.add(new Guitar());
                }
                if ((order.get("guitar") <= guitars.size())) {
                    for (int i = 0; i < order.get("guitar"); i++) {
                        countGuitarsToRemove++;
                    }
                } else {
                    throw new UnsupportedOperationException("Only " + guitars.size() + " guitar(s) exist in the Music Shop");
                }
            } else if ((order.containsKey("guitar")) && (order.get("guitar") <= 0)) {
                throw new IllegalArgumentException("Negative or zero order guitar: " + (order.get("guitar")));
            }                                                                                          // *1
            if ((order.containsKey("piano")) && (order.get("piano") > 0)) {                            // *2 В коде между 1* *1, 2* *2 и 3* *3 повторяющиеся секции кода которые можно вынести в отдельный метод
                for (int i = 0; i < order.get("piano"); i++) {
                    orderList.add(new Piano());
                }
                if ((order.get("piano") <= pianos.size())) {
                    for (int i = 0; i < order.get("piano"); i++) {
                        countPianosToRemove++;
                    }
                } else {
                    throw new UnsupportedOperationException("Only " + pianos.size() + " piano(s) exist in the Music Shop");
                }
            } else if ((order.containsKey("piano")) && (order.get("piano") <= 0)) {
                throw new IllegalArgumentException("Negative or zero order piano: " + (order.get("piano")));
            }                                                                                           // *2
            if ((order.containsKey("trumpet")) && (order.get("trumpet") > 0)) {                         // *3 В коде между 1* *1, 2* *2 и 3* *3 повторяющиеся секции кода которые можно вынести в отдельный метод
                for (int i = 0; i < order.get("trumpet"); i++) {
                    orderList.add(new Trumpet());
                }
                if (order.get("trumpet") <= trumpets.size()) {
                    for (int i = 0; i < order.get("trumpet"); i++) {
                        countTrumpetsToRemove++;
                    }
                } else {
                    throw new UnsupportedOperationException("Only " + trumpets.size() + " trumpet(s) exist in the Music Shop");
                }
            } else if ((order.containsKey("trumpet")) && (order.get("trumpet") <= 0)) {
                throw new IllegalArgumentException("Negative or zero order trumpet: " + (order.get("piano")));
            }                                                                                              // *3
        }
        if(countGuitarsToRemove > 0){
            List<Guitar> guitarsToStay = guitars.subList(countGuitarsToRemove, guitars.size());  // удалить избыточне переменные
            guitars = guitarsToStay;
        }
        if(countPianosToRemove > 0){
            List<Piano> pianosToStay = pianos.subList(countPianosToRemove, pianos.size());  // удалить избыточне переменные
            pianos = pianosToStay;
        }
        if(countTrumpetsToRemove > 0){
            List<Trumpet> trumpetsToStay = trumpets.subList(countTrumpetsToRemove, trumpets.size());  // удалить избыточне переменные
            trumpets = trumpetsToStay;
        }
        return orderList;
    }
}

class InvalidKeyOrderException extends RuntimeException{
    InvalidKeyOrderException(){
        System.out.println("Only guitars, pianos and trumpets sold in this shop, please correct your order");
    }
}

class InvalidOrderException extends RuntimeException{
    InvalidOrderException(){
        System.out.println("Your order must have, at least, one position!");
    }
}
