import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E> {
    private Node<E> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(E... values) {
        for (var value : values) {
            insert(value);
        }
    }

    public void insert(E value) {
        if(root == null) {
            root = new Node<>(value, null, null, null);
            return;
        }

        var parent = root;

        while(parent.getLeftChild() != null && parent.getRightChild() != null) {
            parent = parent.getLeftChild();
        }

        if(parent.getLeftChild() != null) parent.setRightChild(new Node<>(value, parent, null, null));
        else parent.setLeftChild(new Node<>(value, parent, null, null));
    }

    public List<E> toList() {
        return traverseTree(root);
    }

    private List<E> traverseTree(Node<E> currentNode) {
        if(currentNode == null) return null;

        ArrayList<E> result = new ArrayList<>(List.of(currentNode.getValue()));
        if(currentNode.getLeftChild() != null) result.addAll(traverseTree(currentNode.getLeftChild()));
        if(currentNode.getRightChild() != null) result.addAll(traverseTree(currentNode.getRightChild()));

        return result;
    }

    static class Node<T> {
        private T value;
        private Node<T> parent;
        private Node<T> leftChild;
        private Node<T> rightChild;

        public Node(T value, Node<T> parent, Node<T> leftChild, Node<T> rightChild) {
            this.value= value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.parent = parent;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getParent() {
            return parent;
        }

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }
    }
}
