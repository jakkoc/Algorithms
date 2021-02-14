import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class RandomSearchTest
{
    private static final Integer ALPHABET_LENGTH = 26;
    private static final Random random = new Random();

    @Test
    public void smallSortedIntegerArrayTest() {
        Integer[] testArray = new Integer[1000];

        for(int i = 0; i < testArray.length; i++) {
            testArray[i] = i;
        }

        assertEquals(500,RandomSearch.randomSearch(500,testArray));
    }

    @Test
    public void bigRandomStringArrayTest() {
        String[] stringArray = new String[10000];

        for(int i = 0; i < stringArray.length; i++) {
            stringArray[i] = generateRandomString(10);
        }

        assert Arrays.asList(stringArray).contains("jakub") == (RandomSearch.randomSearch("jakub",stringArray) != -1);
    }

    private String generateRandomString(int maximumLength) {
        int length = random.nextInt(maximumLength) + 1;
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < length ; i++) {
            result.append((char)(97 + random.nextInt(ALPHABET_LENGTH)));
        }

        return result.toString();
    }
}