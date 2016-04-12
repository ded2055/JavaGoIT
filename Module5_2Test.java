package src.com.goit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class Module5_2Test {
    Module5_2 actual;
    int[] expcted;

    @Before
    public void setUp() throws Exception {
        actual = new Module5_2();
        expcted = actual.arr.clone();
    }

    @Test
    public void gnomeSort() throws Exception {
        Arrays.sort(expcted);
        System.out.println();
        for (int element : expcted) {
            System.out.print(element+"  ");
        }

        System.out.println();
        Module5_2.gnomeSort(actual.arr);
        for (int element : actual.arr) {
            System.out.print(element+"  ");
        }

        Assert.assertArrayEquals(expcted, actual.arr);
    }

}