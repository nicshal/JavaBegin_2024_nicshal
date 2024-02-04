package nicshal.homework3;

public class HomeWork3 {

    public static void main(String[] args) {
        int[][] testArray1 = {{1, -6, 7}, {5, -8, 67}, {5, 9, 0, -7, 9}};
        System.out.println(sumOfPositiveElements(testArray1));
        printSquare(9);
        int[][] testArray2 = {{1, -6, 7}, {5, -8, 67}, {5, 9, 0}};
        resetDiagonal(testArray2);
        printArray(testArray2);
        System.out.println(findMax(testArray1));
        System.out.println(sumElementsSecondRow(testArray1));
        int[][] testArray3 = {{1, -6, 7}};
        System.out.println(sumElementsSecondRow(testArray3));
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[");
            for (int j = 0; j < array[i].length; j++)
                System.out.print(array[i][j] + (j == array[i].length - 1 ? "" : ", "));
            System.out.print("]");
            System.out.println();
        }
    }

    public static int sumOfPositiveElements(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) sum += array[i][j];
            }
        return sum;
    }

    public static void printSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == (size - 1) || j % (size - 1) == 0) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void resetDiagonal(int[][] array) {
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) array[i][j] = 0;
            }
    }

    public static int findMax(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) max = array[i][j];
            }
        return max;
    }

    public static int sumElementsSecondRow(int[][] array) {
        int sum = 0;
        if (array.length >= 2) {
            for (int j = 0; j < array[1].length; j++) {
                sum += array[1][j];
            }
        } else {
            sum = -1;
        }
        return sum;
    }

}