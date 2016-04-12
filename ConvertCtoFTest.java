//Module 11: Test Class for Module 4.1

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConvertCtoFTest {

    ConvertCtoF convertTest;

    @Before
    public void setup(){
        convertTest = new ConvertCtoF();

    }

    @Test (timeout = 1000)
    public void testCToF() throws Exception {
        double degreeC = 65;
        assertEquals("Test cToF", 1.8*degreeC+32, convertTest.cToF(degreeC), 0);
    }

    @Test (timeout = 10000)
    public void testFToC() throws Exception {
        double degreeF = 65;
        assertEquals("Test fToC", (degreeF-32)/1.8, convertTest.fToC(degreeF), 0);
    }

}