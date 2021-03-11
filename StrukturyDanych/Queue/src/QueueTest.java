import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
    @Test
    public void simpleQueueTest() {
        Queue<String> testQueue = new Queue<>("A", "B", "C", "D", "E");

        assertThrows(Queue.FullStackException.class,() -> testQueue.enqueue("F"));
        assertTrue(testQueue.isFull());

        for (int i = 0; i < 5; i++) {
            testQueue.dequeue();
        }

        assertThrows(Queue.EmptyStackException.class, testQueue::dequeue);
        assertTrue(testQueue.isEmpty());
    }
}