import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Queue<E> {
    E[] queue;
    int head;
    int tail;

    public Queue(int size) {
        queue = (E[])new Object[size];
        head = 0;
        tail = 0;
    }

    public Queue(E... elements) {
        queue = Arrays.copyOf(elements, elements.length + 1);
        head = 0;
        tail = elements.length;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return head - 1 == tail || head == 0 && tail == queue.length - 1;
    }

    public void enqueue(E newElement) {
        if (isFull()) {
            Logger.getLogger("global").log(Level.FINE, "Queue is full - did not add element", newElement);
            throw new FullStackException();
        }

        queue[tail] = newElement;
        tail = (tail + 1) % queue.length;
    }

    public E dequeue() {
        if(isEmpty()) {
            Logger.getLogger("global").log(Level.FINE, "Failed to retrieve an element - empty queue");
            throw new EmptyStackException();
        }

        E returnValue = queue[head];
        head = (head + 1) % queue.length;

        return returnValue;
    }

    static class FullStackException extends RuntimeException {
        public FullStackException() {
        }

        public FullStackException(String message) {
            super(message);
        }
    }

    static class EmptyStackException extends RuntimeException {
        public EmptyStackException() {
        }

        public EmptyStackException(String message) {
            super(message);
        }
    }
}
