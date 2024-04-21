package nicshal.homework20;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final int NUMBER_ATTEMPTS = 3;

    public static void main(String[] args) {
        List<String> fileList = generateFileList();
        if (fileList.isEmpty()) {
            System.out.println("В корневом каталоге не найдено текстовых файлов");
        } else {
            printFileList(fileList);
            Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
            int count = 0;
            while (count < NUMBER_ATTEMPTS) {
                String inputFileName = getFileName(scanner);
                if (fileList.contains(inputFileName)) {
                    handler(scanner, inputFileName);
                    break;
                } else {
                    System.out.println("Файл " + inputFileName + " не найден в корневом каталоге. Осталось " +
                            (NUMBER_ATTEMPTS - ++count) + " попыток");
                }
            }
        }
    }

    public static List<String> generateFileList() {
        List<String> fileList = new ArrayList<>();
        File file = new File(".");
        for (File item : file.listFiles()) {
            if (item.getName().endsWith(".txt")) {
                fileList.add(item.getName());
            }
        }
        return fileList;
    }

    public static void handler(Scanner scanner, String inputFileName) {
        String findString = getCharacterSet(scanner);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName, StandardCharsets.UTF_8))) {
            System.out.println("Число вхождение набора символов '" + findString +
                    "' в файл " + inputFileName + " равно " + countNumberOccurrences(bufferedReader, findString));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printFileList(List<String> fileList) {
        System.out.println("Для обработки доступны следующие текстовые файлы:");
        for (String fileName : fileList) {
            System.out.println(fileName);
        }
    }

    public static int countNumberOccurrences(BufferedReader bufferedReader, String findString) throws IOException {
        String rec;
        int quantity = 0;
        while ((rec = bufferedReader.readLine()) != null) {
            quantity += (rec.split(findString).length) - 1;
        }
        return quantity;
    }

    public static String getFileName(Scanner scanner) {
        System.out.println("Введите имя файла, в которым Вы будете осуществлять поиск:");
        return scanner.nextLine();
    }

    public static String getCharacterSet(Scanner scanner) {
        System.out.println("Введите набор символов, для подсчета вхождения этого набора в файл:");
        return scanner.nextLine();
    }

}