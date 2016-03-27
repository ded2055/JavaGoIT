/*Реализовать сохранение/загрузку текстового сообщения в файл с предварительным шифрованием/расшифрованием.
  Предусмотреть обработку различных ошибок ввода/вывода.*/

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class Module10 {
    public static void main(String[] args) {
        System.out.println("Type your text to encrypt and save: ");
        Scanner in = new Scanner(System.in);
        File outputFile = new File("outputFile");

        byte[] encryptedString = EncryptXor.encrypt(in.nextLine(),"KeyWord");

        try(BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(outputFile))
        ){
            writer.write(encryptedString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(outputFile))){
            System.out.println("Decrypted text: "+ EncryptXor.decrypt(Files.readAllBytes(outputFile.toPath()), "KeyWord"));
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class EncryptXor {

    static byte[] encrypt(String text, String key)
    {
        byte[] textByteArr = text.getBytes();
        byte[] keyByteArr = key.getBytes();
        byte[] resultByteArray = new byte[textByteArr.length];

        for(int i = 0; i< textByteArr.length; i++) {
            resultByteArray[i] = (byte) (textByteArr[i] ^ keyByteArr[i % keyByteArr.length]);
        }

        return resultByteArray;
    }

    static String decrypt(byte[] text, String key) {

        byte[] resultByteArr  = new byte[text.length];
        byte[] keyByteArr = key.getBytes();

        for(int i = 0; i < text.length;i++) {

            resultByteArr[i] = (byte) (text[i] ^ keyByteArr[i% keyByteArr.length]);

        }
        return new String(resultByteArr);
    }
}


