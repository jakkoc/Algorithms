import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {
    private static final Random random = new Random();

    @Test
    public void smallRandomIntegerTest() {
        var testList = generateRandomIntegerList(100, - 1000, 1000);
        var copy = (ArrayList<Integer>)testList.clone();

        var hashTable = new HashTable<Integer>(50);
        hashTable.insertAll(testList);
    }

    @Test
    public void bigRandomIntegerTest() {
        var testList = generateRandomIntegerList(10000, - 10000, 10000);
        var copy = (ArrayList<Integer>)testList.clone();

        var hashTable = new HashTable<Integer>(1000);
        hashTable.insertAll(testList);
    }

    @Test
    public void bigRandomStringTest() {
        var testList = generateRandomStringList(10000, 50);
        var copy = (ArrayList<String>)testList.clone();

        var hashTable = new HashTable<String>(1000);
        hashTable.insertAll(testList);
    }

    private static ArrayList<Integer> generateRandomIntegerList(int size, int minValue, int maxValue) {
        var result = new ArrayList<Integer>();

        for (int i = 0; i < size; i++) {
            result.add(minValue + random.nextInt(maxValue - minValue + 1));
        }

        return result;
    }

    private static ArrayList<String> generateRandomStringList(int size, int maximumLength) {
        var result = new ArrayList<String>();

        for (int i = 0; i < maximumLength; i++) {
            result.add(generateRandomWord(maximumLength));
        }

        return result;
    }

    private static String generateRandomWord(int maximumLength) {
        int actualLength = 1 + random.nextInt(maximumLength);
        var result = new StringBuilder();

        for (int i = 0; i < actualLength; i++) {
            result.append((random.nextInt(26) + 'a'));
        }

        return result.toString();
    }
}