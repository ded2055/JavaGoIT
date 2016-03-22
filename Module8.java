/*
Выбрать иерархию классов из ДЗ по теме OOP in Java и создать несколько коллекций объектов из данной иерархии.
Хотя бы одна коллекция должна содержать в себе объекты разных классов.
Создать класс, который печатает созданные коллекции на экран в виде таблицы.
Колонки таблицы соответствуют полям объектов. Каждая строка в таблице соответствует объекту из коллекции.
2. Создать упорядоченный список объектов из ДЗ по теме OOP in Java не прибегая к  использованию Collections.sort().

*/

import java.util.ArrayList;
import java.util.List;

public class Module8 {
    public static void main(String[] args) {
        Directory dir = new Directory("New Folder", "c:\\GoItOnline2\\Module8");

        System.out.println();

        for (int i = 0; i < 10; i++) {
            dir.audioFiles.add(new AudioFile("AudioFile_"+(i+1), dir.path + "\\" + dir.name+"\\"));
            dir.textFiles.add(new TextFile("TextFile_"+(i+1), dir.path + "\\" + dir.name+"\\"));
            dir.imageFiles.add(new ImageFile("ImageFile_"+(i+1), dir.path + "\\" + dir.name+"\\"));
        }
        dir.fileList = dir.getFileList();

        System.out.println("Unsorted list of files in "+dir.path+ dir.name+"\\");
        Directory.printFileList(dir.fileList);

        System.out.println();
        System.out.println("Sorted by name list of files in "+dir.path+ dir.name+"\\");
        Directory.sortByName(dir.fileList);
        Directory.printFileList(dir.fileList);
    }
}

class File {
    private String name;
    private String extension = "";
    private String fullName;
    private String path;

    File(){
        throw new CantCreateFileException();
    }
    File(String name){
        this.name = name;
        this.fullName = this.name+"."+this.extension;
    }

    String getPath() { return path; }

    void setPath(String path) { this.path = path; }

    String getName() { return name; }

    void setName(String name) {
        this.name = name;
    }

    String getExtension() { return extension; }

    void setExtension(String extension) {
        this.extension = extension;
    }

    String getFullName() { return fullName; }

    void setFullName(String fullName) {
        this.fullName = fullName;
    }

}

class TextFile extends File {
    TextFile(){}

    TextFile(String name, String path){
        super(name);
        setExtension(".txt");
        setFullName(getName()+getExtension());
        setPath(path);
    }
}
class AudioFile extends File {

    AudioFile(){}

    AudioFile(String name, String path){
        super(name);
        setExtension(".mp3");
        setFullName(getName()+getExtension());
        setPath(path);
    }
}
class ImageFile extends File {
    ImageFile(){}

    ImageFile(String name, String path){
        super(name);
        setExtension(".jpeg");
        setFullName(name+getExtension());
        setPath(path);
    }
}

class Directory {
    String name;
    String path;

    List<TextFile> textFiles;
    List<AudioFile> audioFiles;
    List<ImageFile> imageFiles;
    List<File> fileList;


    Directory(String name, String path) {
        this.name = name;
        this.path = path;
        textFiles = new ArrayList<>();
        audioFiles = new ArrayList<>();
        imageFiles = new ArrayList<>();
    }

    List<File> getFileList() {
        List<File> files = new ArrayList<>();
        files.addAll(textFiles);
        files.addAll(audioFiles);
        files.addAll(imageFiles);
        return files;
    }

    static void printFileList(List<File> fileList) {
        String AlignFormat = "| %-12s |   %-9s | %-17s | %-16s |%n";
        System.out.format("+--------------+-------------+-------------------+------------------------------------+%n");
        System.out.format("| File name    | Extension   | File full name    | Path                               |%n");
        System.out.format("+--------------+-------------+-------------------+------------------------------------+%n");
        fileList
                .stream()
                .forEach(f -> System.out.format(AlignFormat,
                        f.getName(), f.getExtension(), f.getFullName(), f.getPath())
                );
        System.out.format("+--------------+-------------+-------------------+------------------------------------+%n");

    }

    static void sortByName(List<File> fileList) {
        int i = 1;
        while (i < fileList.size()) {
            if (i == 0 || (fileList.get(i - 1).getName().compareTo(fileList.get(i).getName()) <= 0))
                i++;
            else {
                File temp = fileList.get(i);
                fileList.set(i, fileList.get(i - 1));
                fileList.set(i - 1, temp);
                i--;
            }
        }
    }
}



class CantCreateFileException extends RuntimeException{
    CantCreateFileException(){
        System.out.println("To create file type name and path");
    }
}