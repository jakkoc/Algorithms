import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    @Test
    public void simpleLinkedListTest() {
        LinkedList<String> testList = new LinkedList<>("A" , "B", "C", "D");

        assertTrue(testList.find("A").getSuccessor().getValue().equals("B"));
        assertTrue(testList.find("D").getSuccessor() == null);

        testList.insert("E");

        assertTrue(testList.find("E").getPredecessor() == null && testList.find("E").getSuccessor().getValue().equals("A"));

        testList.delete("B");

        assertTrue(testList.find("A").getSuccessor().getValue().equals("C") && testList.find("C").getPredecessor().getValue().equals("A"));
    }
}