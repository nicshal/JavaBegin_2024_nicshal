package nicshal.homework12;

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
            Scanner scanner = new Scanner(System.in);
            int count = 0;
            while (count < NUMBER_ATTEMPTS) {
                String inputFileName = getFileName(scanner);
                if (fileList.contains(inputFileName)) {
                    try (InputStreamReader in = new InputStreamReader(new FileInputStream(inputFileName));
                         BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(inputFileName, true))) {
                        printFileContents(in);
                        writeCommentToFileContents(out, getComment(scanner), inputFileName);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                } else {
                    System.out.println("Файл " + inputFileName + " не найден в корневом каталоге. Осталось " + (NUMBER_ATTEMPTS - ++count) + " попыток");
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

    public static void printFileList(List<String> fileList) {
        System.out.println("Для просмотра и редактирования доступны следующие текстовые файлы:");
        for (String fileName : fileList) {
            System.out.println(fileName);
        }
    }

    public static void printFileContents(InputStreamReader in) throws IOException {
        int n = in.read();
        while (n != -1) {
            System.out.print((char) n);
            n = in.read();
        }
        System.out.println("---");
    }

    public static void writeCommentToFileContents(BufferedOutputStream out, String comment, String fileName) throws IOException {
        if (comment.trim().isEmpty()) {
            System.out.println("Вы не оставили комментарий");
        } else {
            comment = "\n---\n" + comment;
            byte[] buffer = comment.getBytes(StandardCharsets.UTF_8);
            for (byte b : buffer) {
                out.write(b);
            }
            System.out.println("Ваш комментарий записан в файл " + fileName);
        }
    }

    public static String getFileName(Scanner scanner) {
        System.out.println("Введите имя файла, с которым Вы будете работать:");
        return scanner.nextLine();
    }

    public static String getComment(Scanner scanner) {
        System.out.println("Напишите свой комментарий к прочитанному:");
        return scanner.nextLine();
    }

}