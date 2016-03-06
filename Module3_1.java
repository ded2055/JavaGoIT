public class Module3_1 {}

class File {}

class TextFile extends File {}
class AudioFile extends File {}
class ImageFile extends File {}

class Directory{
    TextFile[] textFiles;
    AudioFile[] audioFiles;
    ImageFile[] imageFiles;
}