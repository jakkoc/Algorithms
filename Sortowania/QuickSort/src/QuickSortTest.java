import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest
{
    private static final Random random = new Random();
    private static final Integer ALPHABET_LENGTH = 26;

    @Test
    public void smallIntegerArrayTest() {
        Integer[] testArray = {3,5,2,7,1,2,8,9};
        Integer[] comparisonArray = Arrays.copyOf(testArray, testArray.length);

        QuickSort.quickSort(testArray,Integer::compare);
        Arrays.sort(comparisonArray);

        assertArrayEquals(comparisonArray,testArray);
    }

    @Test
    public void largeRandomIntegerArrayTest() {
        Integer[] testArray = generateRandomIntegerArray(100000,-500000,500000);
        Integer[] comparisonArray = Arrays.copyOf(testArray,testArray.length);

        QuickSort.quickSort(testArray,(x,y) -> Integer.compare(y,x));
        Arrays.sort(comparisonArray,(x,y) -> Integer.compare(y,x));

        assertArrayEquals(comparisonArray, testArray);
    }

    @Test
    public void largeRandomStringArrayTest() {
        String[] testArray = generateRandomStringArray(1000000,25);
        String[] comparisonArray = Arrays.copyOf(testArray, testArray.length);

        QuickSort.quickSort(testArray, String.CASE_INSENSITIVE_ORDER);
        Arrays.sort(comparisonArray, String.CASE_INSENSITIVE_ORDER);

        assertArrayEquals(comparisonArray, testArray);
    }

    private static Integer[] generateRandomIntegerArray(int size, int minValue, int maxValue) {
        Integer[] result = new Integer[size];

        for(int i = 0; i < size; i++) {
            result[i] = minValue + random.nextInt(maxValue - minValue + 1);
        }

        return result;
    }

    private static String[] generateRandomStringArray(int size, int maxLength) {
        String[] result = new String[size];

        for(int i = 0; i < size; i++) {
            result[i] = generateRandomString(maxLength);
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