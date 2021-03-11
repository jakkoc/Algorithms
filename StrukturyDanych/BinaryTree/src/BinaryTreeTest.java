import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {
    @Test
    public void simpleBinaryTreeTest() {
        var binaryTree = new BinaryTree<>("A", "B", "C", "D", "E");
        binaryTree.insert("F");
        assertEquals(binaryTree.toList().size(), 6);
    }
}