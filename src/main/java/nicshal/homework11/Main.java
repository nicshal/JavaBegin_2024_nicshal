package nicshal.homework11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 3, 5, 13, 14, 34, 56, 67, 77));
        Tree<Integer> tree1 = new Tree<>(list1);
        System.out.println(tree1);
        System.out.println(tree1.getSortedList());
        System.out.println(tree1.find(77));
        System.out.println(tree1.find(4));

        List<String> list2 = new ArrayList<>(Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff", "rrr", "xxx", "yyy"));
        Tree<String> tree2 = new Tree<>(list2);
        System.out.println(tree2);
        System.out.println(tree2.getSortedList());
        System.out.println(tree2.find("xxx"));
        System.out.println(tree2.find("abc"));

        List<String> list3 = null;
        Tree<String> tree3 = new Tree<>(list3);
        System.out.println(tree3);
        System.out.println(tree3.getSortedList());
        System.out.println(tree3.find("xxx"));
    }

}