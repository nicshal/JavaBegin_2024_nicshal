package nicshal.homework22;

import java.util.*;

public class CheckArray {

    public List<Integer> filterArray(List<Integer> inputArray) {
        if (inputArray == null || inputArray.isEmpty()) {
            throw new RuntimeException("На вход процедуре передан пустой массив");
        }
        int index = inputArray.lastIndexOf(1);
        if (index == -1) {
            throw new RuntimeException("Переданный массив не содержит число 1");
        } else {
            return new ArrayList<>(inputArray.subList(index + 1, inputArray.size()));
        }
    }

    public boolean checkArray(List<Integer> inputArray) {
        if (inputArray == null || inputArray.isEmpty()) {
            throw new RuntimeException("На вход процедуре передан пустой массив");
        }
        Set<Integer> workSet = new HashSet<>(inputArray);
        return workSet.size() == 2 && workSet.containsAll(new ArrayList<>(Arrays.asList(1, 2)));
    }

}