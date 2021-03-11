import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    @Test
    public void simpleStackTest() {
        Stack<String> testStack = new Stack<>(5);
        assertThrows(Stack.EmptyStackException.class, testStack::pop);
        assertThrows(Stack.EmptyStackException.class, testStack::top);

        testStack = new Stack<>("A", "B", "C", "D", "E");

        Stack<String> finalTestStack = testStack;
        assertThrows(Stack.FullStackException.class,() -> finalTestStack.push("F"));

        assertFalse(testStack.isEmpty());
    }
}