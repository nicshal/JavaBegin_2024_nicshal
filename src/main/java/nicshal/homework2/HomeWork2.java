package nicshal.homework2;

import java.util.Arrays;

public class HomeWork2 {

    public static void main(String[] args) {
        int[] testArr = {1, 5, 7, 9, 0, 6};
        printString(5, "Home work number 2");
        printSumArray(testArr);
        fillArray(77, testArr);
        System.out.println(Arrays.toString(testArr));
        testArr[0] = 0;
        testArr[testArr.length - 1] = 4;
        incrementArrayItems(5, testArr);
        System.out.println(Arrays.toString(testArr));
        searchArray(testArr);
    }

    public static void printString(int count, String str) {
        for (int i = 1; i <= count; i++) {
            System.out.println(str);
        }
    }

    public static void printSumArray(int[] arr) {
        if (arr == null) {
            System.out.println("Ошибка: передано некорректное значение arr = " + Arrays.toString(arr));
        } else {
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > 5) {
                    sum += arr[j];
                }
            }
            System.out.println(sum);
        }
    }

    public static void fillArray(int fill, int[] arr) {
        if (arr != null) {
            for (int j = 0; j < arr.length; j++) {
                arr[j] = fill;
            }
        }
    }

    public static void incrementArrayItems(int inc, int[] arr) {
        if (arr != null) {
            for (int j = 0; j < arr.length; j++) {
                arr[j] += inc;
            }
        }
    }

    public static void searchArray(int[] arr) {
        if (arr == null) {
            System.out.println("Ошибка: передано некорректное значение arr = " + Arrays.toString(arr));
        } else if (arr.length % 2 != 0) {
            System.out.println("Ошибка: массив содержит нечетное количество элементов. " +
                    "Разделение на две равные половины (по количеству элементов) невозможно");
        } else {
            int sum1 = 0, sum2 = 0;
            int ln = arr.length / 2;

            for (int j = 0; j < arr.length; j++) {
                if (j / ln == 0) {
                    sum1 += arr[j];
                } else {
                    sum2 += arr[j];
                }
            }

            if (sum1 > sum2) {
                System.out.println("Сумма элементов первой половины массива (" + sum1 +
                        ") больше суммы элементов второй половины массива (" + sum2 + ")");
            } else if (sum1 < sum2) {
                System.out.println("Сумма элементов первой половины массива (" + sum1 +
                        ") меньше суммы элементов второй половины массива (" + sum2 + ")");
            } else {
                System.out.println("Сумма элементов первой половины массива (" + sum1 +
                        ") равна сумме элементов второй половины массива (" + sum2 + ")");
            }
        }
    }

}