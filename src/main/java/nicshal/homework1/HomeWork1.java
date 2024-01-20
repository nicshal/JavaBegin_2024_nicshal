package nicshal.homework1;

import java.util.Random;
import java.util.Scanner;

public class HomeWork1 {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от 0 до 4");
        int i = scanner.nextInt();
        if (i == 0) {
            greetings();
        } else if (i == 1) {
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            int c = random.nextInt(100);
            checkSign(a, b, c);
        } else if (i == 2) {
            selectColor();
        } else if (i == 3) {
            compareNumbers();
        } else if (i == 4) {
            int initValue = random.nextInt(100);
            int delta = random.nextInt(100);
            addOrSubtractAndPrint(initValue, delta, true);
        } else {
            System.out.println("Введено некорректное число");
        }
    }

    public static void greetings() {
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
    }

    public static void checkSign(int a, int b, int c) {
        if (a + b + c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor() {
        int data = 15;
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 5, b = 9;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            System.out.println(initValue + delta);
        } else {
            System.out.println(initValue - delta);
        }
    }

}