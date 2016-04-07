/*Домашнее задание к Модулю 5
2.2 Выбрать один из алгоритмов сортировки массивов и реализовать его
*/
package src.com.goit;

public class Module5_2 {
    int[] arr;

    Module5_2() {
        arr = new int[21];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
            System.out.print(arr[i] + "  ");
        }
    }
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
       Module5_2 module5_2 = new Module5_2();

        System.out.println();
        gnomeSort(module5_2.arr);
            for(int element : module5_2.arr){
            System.out.print(element + "  ");
        }

    }
}
