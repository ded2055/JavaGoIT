import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class TriangleTest {
    Triangle triangle;

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Before
    public void setUp() throws Exception {
        systemInMock.provideLines("65\n76");
        triangle = new Triangle();
    }

    @Test (timeout = 1000)
    public void testFindSquare() throws Exception {
        assertEquals("Triangle area", 0.5 * (triangle.heightTriangle * triangle.baseTriangle), triangle.findSquare(),0);

    }

}