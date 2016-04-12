import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

@RunWith(Theories.class)
public class CircleTest {
    Circle circle;

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @DataPoints
    public static int[][] radiusData = new int[][]{
            {65},
            {72},
            {23},
            {12},
            {11},
    };

    @Theory
    public void testFindSquare(int... radiusData) throws Exception {
        systemInMock.provideLines(String.valueOf(radiusData[0]));
        circle = new Circle();
        assertEquals("Circle area", Math.pow(circle.radius,2)*Math.PI, circle.findSquare(),0);
    }

}