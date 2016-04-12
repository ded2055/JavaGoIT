import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class RectangleTest {
    Rectangle rectangle;

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Before
    public void setUp() throws Exception {
        systemInMock.provideLines("13\n17");
        rectangle = new Rectangle();
    }

    @Test (timeout = 1000)
    public void testFindSquare() throws Exception {
        Assert.assertEquals("Rectangle area", rectangle.sideA*rectangle.sideB, rectangle.findSquare(), 0);
    }

}