import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class EncryptXorTest {
    static String text;
    static byte[] encryptedText;

    @BeforeClass
    public static void setUpClass() throws Exception {
        text = "Text of Module 11, that must be encrypted!";
    }

    @Test
    public void encrypt() throws Exception {
        encryptedText = EncryptXor.encrypt(text, "passPhrase");
        Assert.assertFalse("Test encrypt", text.equals(encryptedText.toString()));
    }

    @Test
    public void decrypt() throws Exception {
        Assert.assertTrue("Test decrypt", text.equals(EncryptXor.decrypt(encryptedText, "passPhrase")));
    }
}