package nicshal.homework12;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final int NUMBER_ATTEMPTS = 3;

    public static void main(String[] args) {
        List<String> fileList = new ArrayList<>();
        File file = new File(".");
        for (File item : file.listFiles()) {
            if (item.getName().endsWith(".txt")) {
                fileList.add(item.getName());
            }
        }

        if (fileList.isEmpty()) {
            System.out.println("В корневом каталоге не найдено текстовых файлов");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Для просмотра и редактирования доступны следующие текстовые файлы:");
            for (String fileName : fileList) {
                System.out.println(fileName);
            }

            int count = 0;
            String inputFileName;
            while (count < NUMBER_ATTEMPTS) {
                System.out.println("Введите имя файла, с которым Вы будете работать:");
                inputFileName = scanner.nextLine();
                if (fileList.contains(inputFileName)) {
                    try (InputStreamReader in = new InputStreamReader(new FileInputStream(inputFileName));
                         BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(inputFileName, true))) {
                        int n = in.read();
                        while (n != -1) {
                            System.out.print((char) n);
                            n = in.read();
                        }

                        System.out.println("Напишите свой комментарий к прочитанному:");
                        String comment = scanner.nextLine();
                        if (comment.trim().isEmpty()) {
                            System.out.println("Вы не оставили комментарий");
                        } else {
                            comment = "\n---\n" + comment;
                            byte[] buffer = comment.getBytes(StandardCharsets.UTF_8);
                            for (byte b : buffer) {
                                out.write(b);
                            }
                            System.out.println("Ваш комментарий записан в файл " + inputFileName);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                } else {
                    count += 1;
                    System.out.println("Файл " + inputFileName + " не найден в корневом каталоге. Осталось " +
                            (NUMBER_ATTEMPTS - count) + " попыток");
                }
            }
        }
    }
}