package nicshal.homework8;

public class Main {

    public static final int NUMBER_ROWS = 4;
    public static final int NUMBER_COLUMNS = 4;

    public static final String ARRAY_DATA_ERROR =
            "Значение %s из ячейки массива [%s][%s] не удалось преобразовать в целое число";
    public static final String ARRAY_SIZE_ERROR =
            "Одна из размерностей массива (определено значение %s) не соответствует установленному ограничению (%s = %s)";

    public static void main(String[] args) {
        String[][] testArray1 = {
                {"1", "67", "8", "44"},
                {"10", "6", "88", "44"},
                {"15", "2", "9", "155"},
                {"17", "6", "23", "44"}
        };
        String[][] testArray2 = {
                {"1", "67", "8", "44"},
                {"10", "6", "88", "44", "90"},
                {"15", "2", "9", "55"},
                {"17", "6", "23", "44"}
        };
        String[][] testArray3 = {
                {"1", "67", "8", "44"},
                {"10", "6", "88", "44"},
                {"15", "2", "9", "55"},
                {"17", "6", "23", "44"},
                {"151", "21", "91", "551"}
        };
        String[][] testArray4 = {
                {"1", "67", "8", "44"},
                {"10", "6", "g", "44"},
                {"15", "2", "9", "55"},
                {"17", "6", "23", "44"}
        };

        try {
            System.out.println("Сумма злементов тестового массива testArray1 = " + sumItems(testArray1));
        } catch (RuntimeException err) {
            System.out.println("Поймали ошибку: " + err);
        }
        try {
            System.out.println("Сумма злементов тестового массива testArray2 = " + sumItems(testArray2));
        } catch (RuntimeException err) {
            System.out.println("Поймали ошибку: " + err);
        }
        try {
            System.out.println("Сумма злементов тестового массива testArray3 = " + sumItems(testArray3));
        } catch (RuntimeException err) {
            System.out.println("Поймали ошибку: " + err);
        }
        try {
            System.out.println("Сумма злементов тестового массива testArray4 = " + sumItems(testArray4));
        } catch (RuntimeException err) {
            System.out.println("Поймали ошибку: " + err);
        }
    }

    public static int sumItems(String[][] stringArray) {
        if (stringArray.length != NUMBER_ROWS)
            throw new AppArraySizeException(String.format(ARRAY_SIZE_ERROR, stringArray.length, "NUMBER_ROWS", NUMBER_ROWS));
        int sum = 0;
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].length != NUMBER_COLUMNS)
                throw new AppArraySizeException(String.format(ARRAY_SIZE_ERROR, stringArray[i].length, "NUMBER_COLUMNS", NUMBER_COLUMNS));
            for (int j = 0; j < stringArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(stringArray[i][j]);
                } catch (NumberFormatException err) {
                    throw new AppArrayDataException(String.format(ARRAY_DATA_ERROR, stringArray[i][j], i, j), err);
                }
            }
        }
        return sum;
    }

}