import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CeasarEncryptionTest {
    static CeasarEncryption encryptCeasar;
    static String text;
    static String encryptedText;

    @BeforeClass
    public static void setUpClass() throws Exception{
        encryptCeasar = new CeasarEncryption();
        text = "roses, asters, chamomiles";
    }

    @Test (timeout = 1000)
    public void encrypt() throws Exception {
        encryptedText = encryptCeasar.encrypt(text,7);
        Assert.assertFalse("Encrypt test", text.equals(encryptedText));
    }

    @Test (timeout = 1000)
    public void decrypt() throws Exception {
        String decrypt = encryptCeasar.decrypt(encryptedText, 7);
        Assert.assertTrue("Decrypt test", text.equals(decrypt));
    }
}