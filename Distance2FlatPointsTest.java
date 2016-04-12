//Module 11: Test Class for Module 4.2

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Distance2FlatPointsTest {
    Distance2FlatPoints dst;

    @Before
    public void setUp() throws Exception {
        dst = new Distance2FlatPoints();
    }

    @Test (timeout = 1000)
    public void testDistance() throws Exception {
        double x1 = 12;
        double x2 = 56;
        double y1 = 44;
        double y2 = 3;
        double expected = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        assertEquals("Test distance", expected, dst.distance(x1, y1, x2, y2), 10);
    }

}