package nicshal.homework11;

import java.util.ArrayList;
import java.util.List;

public class Tree<T extends Comparable<T>> implements SearchTree<T> {

    private TreeNode<T> rootNode;

    public Tree(List<T> list) {
        rootNode = sortedArrayToTree(list);

    }

    public TreeNode<T> getRootNode() {
        return rootNode;
    }

    @Override
    public T find(T element) {
        return findElement(rootNode, element);
    }

    @Override
    public List<T> getSortedList() {
        List<T> list = new ArrayList<>();
        generateList(rootNode, list);
        return list;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "rootNode=" + rootNode +
                '}';
    }

    private TreeNode<T> sortedArrayToTree(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return sortedArrayToTree(list, 0, list.size() - 1);
    }

    private TreeNode<T> sortedArrayToTree(List<T> list, int start, int end) {
        if (start > end) return null;
        int middle = start + (end - start) / 2;
        TreeNode<T> node = new TreeNode<>(list.get(middle));
        node.setLeftNode(sortedArrayToTree(list, start, middle - 1));
        node.setRightNode(sortedArrayToTree(list, middle + 1, end));
        return node;
    }

    private void generateList(TreeNode<T> node, List<T> list) {
        if (node == null) {
            return;
        }
        generateList(node.getLeftNode(), list);
        list.add(node.getItem());
        generateList(node.getRightNode(), list);
    }

    private T findElement(TreeNode<T> node, T element) {
        if (node == null || element == null) {
            return null;
        }
        if (element == node.getItem()) {
            return element;
        } else if (element.compareTo(node.getItem()) < 0) {
            return findElement(node.getLeftNode(), element);
        } else {
            return findElement(node.getRightNode(), element);
        }
    }

}