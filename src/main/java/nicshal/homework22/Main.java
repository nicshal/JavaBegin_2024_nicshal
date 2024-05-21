package nicshal.homework22;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        CheckArray checkArray = new CheckArray();

        System.out.println(checkArray.filterArray(new ArrayList<>(Arrays.asList(3, 6, 1, 0, 4, 7, 6, 77))));
        System.out.println(checkArray.filterArray(new ArrayList<>(Arrays.asList(3, 6, 11, 0, 4, 7, 6, 77, 1))));
        System.out.println(checkArray.filterArray(new ArrayList<>(Arrays.asList(3, 6, 1, 0, 4, 7, 1, 77, 134))));
        try {
            System.out.println(checkArray.filterArray(new ArrayList<>(Arrays.asList(3, 6, 11, 0, 4, 7, 6, 77))));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        System.out.println(checkArray.checkArray(new ArrayList<>(Arrays.asList(3, 6, 1, 0, 4, 7, 1, 77, 134))));
        System.out.println(checkArray.checkArray(new ArrayList<>(Arrays.asList(1, 3, 2, 2))));
        System.out.println(checkArray.checkArray(new ArrayList<>(Arrays.asList(1, 2, 2, 2))));
    }

}