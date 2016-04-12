package src.com.goit;

import org.junit.*;

import java.util.Arrays;

public class Module5_1Test {
    Module5_1 module5_1;

    @Before
    public void setUp() throws Exception {
        module5_1 = new Module5_1();
    }

    @Test
    public void testMinMaxFind() throws Exception {
        Arrays.sort(module5_1.arr);
        Assert.assertEquals("Find maximum item", module5_1.arr[module5_1.arr.length-1], module5_1.maxFind());
        Assert.assertEquals("Find minimum item", module5_1.arr[0], module5_1.minFind());
    }
}