/* Домашнее задание к Модулю 5
2.1 Создать класс, который осуществляет поиск максимального и минимального элемента в массиве из целых чисел (int[]).
 */

package src.com.goit;

public class Module5_1 {
    public static void main(String[] args) {
        int[] arr = new int[21];
        for(int i = 0; i <  arr.length; i++) {
            arr[i] =  (int)(Math.random() * 100);
            System.out.print(arr[i] + "  ");
        }

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[j]<arr[i]) j=i;
        }
        int max = arr[j];

        j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[j]>arr[i]) j=i;
        }
        int min = arr[j];

        System.out.println("\nMAX = "+max);
        System.out.println("MIN = "+min);

    }
}
