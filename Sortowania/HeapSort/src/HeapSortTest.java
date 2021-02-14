import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest
{
    private static final Integer ALPHABET_LENGTH = 26;
    private static final Random random = new Random();

    @Test
    public void smallIntegerArrayTest() {
        Integer[] testArray = {27,17,3,16,13,10,1,5,7,12,4,8,9,0};
        Integer[] comparisonArray = Arrays.copyOf(testArray,testArray.length);

        HeapSort.maxHeapSort(testArray);
        Arrays.sort(comparisonArray);

        assertArrayEquals(comparisonArray, testArray);

        HeapSort.minHeapSort(testArray);
        Arrays.sort(comparisonArray,(x,y) ->  -1 * Integer.compare(x,y));

        assertArrayEquals(comparisonArray,testArray);
    }

    @Test
    public void bigRandomIntegerArrayTest() {
        Integer[] testArray = generateRandomIntegerArray(100000,-100000,100000);
        Integer[] comparisonArray = Arrays.copyOf(testArray,testArray.length);

        HeapSort.maxHeapSort(testArray);
        Arrays.sort(comparisonArray);
        assertArrayEquals(comparisonArray, testArray);

        HeapSort.minHeapSort(testArray);
        Arrays.sort(comparisonArray, (x,y) -> -1 * Integer.compare(x, y));
        assertArrayEquals(comparisonArray,testArray);
    }

    @Test
    public void bigRandomStringArrayTest() {
        String[] testArray = generateRandomStringArray(50,100000);
        String[] comparisonArray = Arrays.copyOf(testArray,testArray.length);

        HeapSort.maxHeapSort(testArray);
        Arrays.sort(comparisonArray);
        assertArrayEquals(comparisonArray, testArray);

        HeapSort.minHeapSort(testArray);
        Arrays.sort(comparisonArray, (x,y) -> -1 * String.CASE_INSENSITIVE_ORDER.compare(x,y));
        assertArrayEquals(comparisonArray, testArray);
    }

    private static Integer[] generateRandomIntegerArray(int size, int minValue, int maxValue) {
        Integer[] result = new Integer[size];

        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }

        return result;
    }

    private static String[] generateRandomStringArray(int maxWordLength, int size) {
        String[] result = new String[size];

        for (int i = 0; i < size; i++) {
            result[i] = generateRandomString(maxWordLength);
        }

        return result;
    }

    private static String generateRandomString(int maxLength) {
        int length = 1 + random.nextInt(maxLength);
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < length; i++) {
            result.append((char)(97 + random.nextInt(ALPHABET_LENGTH)));
        }

        return result.toString();
    }
}