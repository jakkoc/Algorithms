import java.util.logging.Level;
import java.util.logging.Logger;

public class Stack<E> {
    private E[] stack;
    private int top;

    public Stack(int size) {
        if(size <= 0) throw new IllegalArgumentException("Stack: size " + size);
        stack = (E[])new Object[size];
        top = -1;
    }

    public Stack(E... values) {
        stack = values;
        top = values.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(E newValue) {
        if(top == stack.length - 1) {
            Logger.getLogger("global").log(Level.FINE, "The stack was full", newValue);
            throw new FullStackException();
        }

        top = top + 1;
        stack[top] = newValue;
    }

    public E top() {
        if (isEmpty()) {
           Logger.getLogger("global").log(Level.FINER,"Tried to peek on an empty stack");
           throw new EmptyStackException();
        }

        return stack[top];
    }

    public E pop() {
        if(isEmpty()) {
            Logger.getLogger("global").log(Level.FINE, "Tried to retrieve element from an empty stack");
            throw new EmptyStackException();
        }

        top = top - 1;

        return stack[top + 1];
    }

    static class EmptyStackException extends RuntimeException {
        public EmptyStackException() {
        }

        public EmptyStackException(String message) {
            super(message);
        }
    }

    static class FullStackException extends RuntimeException {
        public FullStackException() {
        }

        public FullStackException(String message) {
            super(message);
        }
    }
}
