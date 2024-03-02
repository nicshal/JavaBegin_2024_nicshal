package nicshal.homework11;

public class TreeNode<T> {

    private T item;
    private TreeNode<T> leftNode;
    private TreeNode<T> rightNode;

    public TreeNode(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public TreeNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return TreeNode.class.getSimpleName() + '{' +
                "item=" + item +
                ", leftNode=" + leftNode.item +
                ", rightNode=" + rightNode.item +
                '}';
    }

}