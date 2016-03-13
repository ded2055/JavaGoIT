/*Домашнее задание к Модулю 5
2.2 Выбрать один из алгоритмов сортировки массивов и реализовать его
*/
package src.com.goit;

public class Module5_2 {
    static void gnomeSort(int[] a) {
        int i = 1;
        while(i < a.length) {
            if(i==0 || a[i - 1] <= a[i])
                i++;
            else {
                int temp = a[i];
                a[i] = a[i - 1];
                a[i - 1] = temp;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[21];
        for(int i = 0; i <  arr.length; i++) {
            arr[i] =  (int)(Math.random() * 100);
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
        gnomeSort(arr);
            for(int element : arr){
            System.out.print(element + "  ");
        }

    }
}
