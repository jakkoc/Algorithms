import org.junit.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest
{
    @Test
    public void smallIntegerTest() {
        PriorityQueue<Integer> testQueue = PriorityQueue.empty();
        assertThrows(NoSuchElementException.class,testQueue::first);
        assertThrows(NoSuchElementException.class,testQueue::dequeue);

        for(int i = 1; i <= 100; i++) {
            testQueue.enqueue(i);
        }

        assertEquals(100,testQueue.first());

        ArrayList<Integer> testList = new ArrayList<>();
        ArrayList<Integer> comparisonList = new ArrayList<>();

        for(int i = 0; i < 100; i++) {
            testList.add(testQueue.dequeue());
            comparisonList.add(100 - i);
        }

        assertThrows(NoSuchElementException.class,testQueue::first);
        assertEquals(testList,comparisonList);

        testQueue.enqueue(3);
        testQueue.enqueue(7);
        testQueue.increaseKey(1,123);
        assertEquals(123, testQueue.dequeue());
    }
}