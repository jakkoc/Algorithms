public class LinkedList<E> {
    Node<E> head;

    public LinkedList() {
        head = null;
    }

    public LinkedList(E... values) {
        if (values == null && values.length <= 0) {
            throw new IllegalArgumentException();
        }

        head = new Node<>(values[0], null, null);
        var currentNode = head;

        for (int i = 1; i < values.length; i++) {
            currentNode.setSuccessor(new Node<>(values[i], currentNode, null));
            currentNode = currentNode.getSuccessor();
        }
    }

    public Node<E> find(E key) {
        Node<E> currentNode = head;

        while (currentNode != null && !currentNode.getValue().equals(key)) {
            currentNode = currentNode.getSuccessor();
        }

        return currentNode;
    }

    public Node<E> delete(E key) {
        Node<E> nodeToDelete = find(key);

        if (nodeToDelete != null) {
            if (nodeToDelete.getPredecessor() == null) {
                head = nodeToDelete.getSuccessor();
            } else {
                nodeToDelete.getPredecessor().setSuccessor(nodeToDelete.getSuccessor());
                if (nodeToDelete.getSuccessor() != null)
                    nodeToDelete.getSuccessor().setPredecessor(nodeToDelete.getPredecessor());
            }
        }

        return nodeToDelete;
    }

    public void insert(E value) {
        head = new Node<>(value, null, head);
        if (head.getSuccessor() != null) head.getSuccessor().setPredecessor(head);
    }

    static class Node<T> {
        private T value;
        private Node<T> predecessor;
        private Node<T> successor;

        public Node(T value, Node<T> predecessor, Node<T> successor) {
            this.value = value;
            this.predecessor = predecessor;
            this.successor = successor;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getPredecessor() {
            return predecessor;
        }

        public Node<T> getSuccessor() {
            return successor;
        }

        public void setPredecessor(Node<T> predecessor) {
            this.predecessor = predecessor;
        }

        public void setSuccessor(Node<T> successor) {
            this.successor = successor;
        }
    }
}
