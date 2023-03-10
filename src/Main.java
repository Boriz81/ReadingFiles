import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static String readFileAsString(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
    public static void main(String[] args) throws IOException {
        // Reading Files
        File file = new File("C:\\Users\\user\\IdeaProjects\\Reading Files>\\text.txt");
        try (Scanner scanner2 = new Scanner(file)) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine() + " ");
            }
            scanner = new Scanner(file);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        File file2 = new File("C:\\system.tmp");
        // каноничный пример
        try (Scanner scanner2 = new Scanner(file)) {
            while (scanner2.hasNext()) {
                System.out.println(scanner2.nextLine() + " ");
            }
        } catch (FileNotFoundException e) {

            System.out.println("No file found: " + file2);
        }

        // работаем с многостроковым текстом
        String pathToFileInUsers = "C:\\Users\\user\\folderForFiles\\text.txt";
        // вызываю из метода
        System.out.println(readFileAsString(pathToFileInUsers));
        // вызываю непосредственно
        try {
            System.out.println(new String(Files.readAllBytes(Paths.get(pathToFileInUsers))));
        } catch (Exception e) {
            System.out.println(e.getCause());
        }

        // запись в файл
        String message = "Added text";
        Path path = Path.of("C:\\Users\\user\\folderForFiles\\text.txt");
        Files.writeString(path, message);
    }
}