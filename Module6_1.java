/*Домашнее задание к Модулю 6
1. Дополнить код уже имеющихся классов обработкой исключительной ситуации. При этом использовать УЖЕ СУЩЕСТВУЮЩИЙ класс
(например, IllegalStateException)
 */
public class Module6_1 {
    public static void main(String[] args) {
        try {
            Directory dir = new Directory();
        }catch (IllegalStateException e){
            System.out.println(e);
        }
    }
}

    class File {}

    class TextFile extends File {}
    class AudioFile extends File {}
    class ImageFile extends File {}

    class Directory{
        String path;
        Directory(){
            System.out.println("Error in creating Directory, please enter path");
            throw new IllegalStateException();
        }
        Directory(String path){
            this.path = path;
        }
        TextFile[] textFiles;
        AudioFile[] audioFiles;
        ImageFile[] imageFiles;
    }
