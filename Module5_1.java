/* Домашнее задание к Модулю 5
2.1 Создать класс, который осуществляет поиск максимального и минимального элемента в массиве из целых чисел (int[]).
 */

package src.com.goit;

public class Module5_1 {
    int[] arr;

    Module5_1() {
        arr = new int[21];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
            System.out.print(arr[i] + "  ");
        }
    }

    public int maxFind() {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[j] < arr[i]) j = i;
        }
        System.out.println("\nMAX = " + arr[j]);
        return arr[j];
    }

    public int minFind() {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[j] > arr[i]) j = i;
        }
        System.out.println("MIN = " + arr[j]);
        return arr[j];
    }

    public static void main(String[] args) {
        Module5_1 module5_1 = new Module5_1();
        module5_1.maxFind();
        module5_1.minFind();
    }
}
