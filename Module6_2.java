/* Домашнее задание к Модулю 6
2. Добавить в магазин инструментов метод, который готовит к отгрузке партию музыкальных инструментов согласно заказу.

Сигнатура метода:
public List<Instrument> prepareInstruments(Map<String, Integer> order){...}

В заказе (Map<String, Integer> order) хранится название инструмента и количество необходимых инструментов.

Ключем в заказе является одна из строк "piano", "guitar", "trumpet"

Создать свое исключение, которое будет брошено в случае, когда ключ в заказе другой.

Каким-то образом (самостоятельно выбрать решение) обработать ситуацию, когда количество элементов в заказе отрицательное, нулевое.

После выполнения метода из магазина должны пропасть те инструменты, которые были отгружены.
В случае, когда количество запрашиваемых инструментов определенного типа больше, чем количество доступных инструментов в магазине, должно быть брошено исключение. Выбрать наиболее подходящее из доступных в стандартной библиотеке исключений

 */

import java.util.*;

public class Module6_2 {
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

    public static List<MusicalInstrument> addToOrderList(String instrument, int count){
        List<MusicalInstrument> orderList = new ArrayList<>();
        if (instrument.equals("guitar")) {
            for (int i = 0; i < count; i++) {
                orderList.add(new Guitar());
            }
        }else if (instrument.equals("piano")) {
            for (int i = 0; i < count; i++) {
                orderList.add(new Piano());
            }
        }else if (instrument.equals("trumpet")) {
            for (int i = 0; i < count; i++) {
                orderList.add(new Trumpet());
            }
        }
        return orderList;
    }
    public static int checkOrderInstrumentCount(Map<String, Integer> order, String instrument, int countOfInstrumentsInShop) throws UnsupportedOperationException{
        int countInstrumentsToRemove = 0;
        if (order.get(instrument) <= countOfInstrumentsInShop) {
            for (int i = 0; i < order.get(instrument); i++) {
                countInstrumentsToRemove++;
            }
        } else {
            throw new UnsupportedOperationException("Only " + countOfInstrumentsInShop + " "+instrument+"(s) exist in the Music Shop");
        }
        return countInstrumentsToRemove;
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
                if (!((k.equals("piano")) || (k.equals("guitar")) || (k.equals("trumpet")))) {
                    throw new InvalidKeyOrderException();
                }
            });
        }
        if (order.containsKey("guitar") || order.containsKey("piano") || order.containsKey("trumpet")) {
            if ((order.containsKey("guitar")) && (order.get("guitar") > 0)) {
                orderList.addAll(addToOrderList("guitar", order.get("guitar")));
                countGuitarsToRemove += checkOrderInstrumentCount(order, "guitar", guitars.size());
            } else if ((order.containsKey("guitar")) && (order.get("guitar") <= 0)) {
                throw new IllegalArgumentException("Negative or zero order guitar: " + order.get("guitar"));
            }
            if ((order.containsKey("piano")) && (order.get("piano") > 0)) {
                orderList.addAll(addToOrderList("piano", order.get("piano")));
                countPianosToRemove += checkOrderInstrumentCount(order, "piano", pianos.size());
            } else if ((order.containsKey("piano")) && (order.get("piano") <= 0)) {
                throw new IllegalArgumentException("Negative or zero order piano: " + order.get("piano"));
            }
            if ((order.containsKey("trumpet")) && (order.get("trumpet") > 0)) {
                orderList.addAll(addToOrderList("trumpet", order.get("trumpet")));
                countTrumpetsToRemove += checkOrderInstrumentCount(order, "trumpet", trumpets.size());
            } else if ((order.containsKey("trumpet")) && (order.get("trumpet") <= 0)) {
                throw new IllegalArgumentException("Negative or zero order trumpet: " + order.get("piano"));
            }
        }
        if(countGuitarsToRemove > 0){
            List<Guitar> guitarsToStay = guitars.subList(countGuitarsToRemove, guitars.size());
            guitars = guitarsToStay;
        }
        if(countPianosToRemove > 0){
            List<Piano> pianosToStay = pianos.subList(countPianosToRemove, pianos.size());
            pianos = pianosToStay;
        }
        if(countTrumpetsToRemove > 0){
            List<Trumpet> trumpetsToStay = trumpets.subList(countTrumpetsToRemove, trumpets.size());
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