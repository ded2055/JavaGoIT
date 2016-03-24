/*
 Домашнее задание к Модулю 9
 Grade: N/A
 View Grade InfoView Stats
 Реализовать шифрование текста с помощью алгоритма Цезаря.
 Зашифровать и расшифровать текстовое представление коллекци обьектов из ДЗ из Модуля 3: ООП в Java
 */

import java.util.ArrayList;
import java.util.List;


public class Module9 {
    public static void main(String[] args) {
        String text = "roses, asters, chamomiles}";

        CeaserEncryption ceaser = new CeaserEncryption();

        String en = ceaser.encrypt(text, 7);
        System.out.println("Encrypted text: "+en);

        System.out.println("Decrypted text: "+ceaser.decrypt(en, 7));
    }
}

class CeaserEncryption {
    List<Character> lettersAndNumbers = new ArrayList<>();
    CeaserEncryption(){
        char[] PUNCTUATION = {'.', ',', ';', ':', '!', '?', '-', ' '};

        for (char letter = 'A'; letter <= 'Z'; letter++) {
            lettersAndNumbers.add(letter);
        }
        for (char letter = 'a'; letter <= 'z'; letter++) {
            lettersAndNumbers.add(letter);
        }
        for (char number = '0'; number <= '9'; number++) {
            lettersAndNumbers.add(number);
        }
        for (char c: PUNCTUATION) {
            lettersAndNumbers.add(c);
        }
    }
    String encrypt(String text, int offset) {

        StringBuilder cryptedString = new StringBuilder();

        for (int i = 0; i < text.length()-1; i++) {
            char c = text.charAt(i);
            int index = lettersAndNumbers.indexOf(c);
            index = (index  + offset) % lettersAndNumbers.size();
            cryptedString.append(lettersAndNumbers.get(index));
        }
        return cryptedString.toString();
    }
    String decrypt(String text, int offset){

        StringBuilder decryptedString = new StringBuilder();

        for (int i = 0; i < text.length()-1; i++) {
            char c = text.charAt(i);
            int index = lettersAndNumbers.indexOf(c);
            index = (((index - offset) ) %lettersAndNumbers.size()  + lettersAndNumbers.size()) % lettersAndNumbers.size();
            decryptedString.append(lettersAndNumbers.get(index));
        }
        return decryptedString.toString();

    }
}




