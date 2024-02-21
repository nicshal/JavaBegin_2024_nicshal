package nicshal.homework9;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> testArray = generateList(11, 23);
        System.out.println(testArray);

        ArrayList<Integer> testArray1 = new ArrayList<>(Arrays.asList(3, 6, 1, 0, null, 7, 6, 77));
        System.out.println(sumListItems(testArray1));

        rewriteList(4, testArray1);
        System.out.println(testArray1);

        ArrayList<Integer> testArray2 = new ArrayList<>(Arrays.asList(3, 6, 1, 0, null, 7, 6, 77));
        updateList(7, testArray2);
        System.out.println(testArray2);

        ArrayList<Employee> testArray3 = new ArrayList<>(Arrays.asList(
                new Employee("Петр", 23),
                new Employee("Вася", 45),
                new Employee("Гриша", 12),
                new Employee("Игорь", 33))
        );
        System.out.println(generateEmployeeNameList(testArray3));
        System.out.println(generateOlderEmployeeList(testArray3, 25));
        System.out.println(isOlder(testArray3, 27));
        System.out.println(getYoungestEmployee(testArray3));

    }

    public static ArrayList<Integer> generateList(int min, int max) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = min; i < max; i++) {
            result.add(i);
        }
        return result;
    }

    public static int sumListItems(ArrayList<Integer> list) {
        int sum = 0;
        for (Integer i : list) {
            if (i != null && i > 5) sum += i;
        }
        return sum;
    }

    public static void rewriteList(int delta, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) list.set(i, delta);
        }
    }

    public static void updateList(int delta, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) list.set(i, list.get(i) + delta);
        }
    }

    public static ArrayList<String> generateEmployeeNameList(ArrayList<Employee> employeeList) {
        ArrayList<String> result = new ArrayList<>();
        for (Employee employee : employeeList) {
            result.add(employee.getName());
        }
        return result;
    }

    public static ArrayList<Employee> generateOlderEmployeeList(ArrayList<Employee> employeeList, int minAge) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getAge() >= minAge) result.add(employee);
        }
        return result;
    }

    public static boolean isOlder(ArrayList<Employee> employeeList, int minAverageAge) {
        if (employeeList.isEmpty()) return false;
        int sum = 0;
        for (Employee employee : employeeList) {
            sum += employee.getAge();
        }
        return (sum / employeeList.size()) > minAverageAge;
    }

    public static Employee getYoungestEmployee(ArrayList<Employee> employeeList) {
        if (employeeList.isEmpty()) return null;
        Employee result = null;
        for (Employee employee : employeeList) {
            if (result == null || result.getAge() > employee.getAge()) result = employee;
        }
        return result;
    }

}