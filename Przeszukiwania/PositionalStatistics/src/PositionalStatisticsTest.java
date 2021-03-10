import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class PositionalStatisticsTest {
    private static final Random random = new Random();

    @Test
    public void smallRandomIntegerArrayTest() {
        Integer[] testArray = generateRandomIntegerArray(1000, - 5000, 6000);
        Integer[] comparisonArray = Arrays.copyOf(testArray, testArray.length);

        assertEquals(Arrays.stream(testArray).min(Integer::compare).get(), PositionalStatistics.positionalStatistic(testArray, 1));
        assertEquals(Arrays.stream(testArray).max(Integer::compare).get(), PositionalStatistics.positionalStatistic(testArray, 1000));

        Integer[] sortedArray = new Integer[1000];

        for(int i = 0; i < 1000; i++) {
            sortedArray[i] = PositionalStatistics.positionalStatistic(testArray, i + 1);
        }

        Arrays.sort(comparisonArray);

        assertArrayEquals(comparisonArray, sortedArray);
    }

    @Test
    public void bigRandomIntegerArrayTest() {
        Integer[] testArray = generateRandomIntegerArray(10000, - 50000, 60000);
        Integer[] comparisonArray = Arrays.copyOf(testArray, testArray.length);

        assertEquals(Arrays.stream(testArray).min(Integer::compare).get(), PositionalStatistics.positionalStatistic(testArray, 1));
        assertEquals(Arrays.stream(testArray).max(Integer::compare).get(), PositionalStatistics.positionalStatistic(testArray, 10000));

        Integer[] sortedArray = new Integer[10000];

        for(int i = 0; i < 10000; i++) {
            sortedArray[i] = PositionalStatistics.positionalStatistic(testArray, i + 1);
        }

        Arrays.sort(comparisonArray);

        assertArrayEquals(comparisonArray, sortedArray);
    }

    @Test
    public void reverseSortedIntegerArrayTest() {
        Integer[] testArray = new Integer[1000];

        for(int i = 0; i < 1000; i++) {
            testArray[i]= 1000 - i;
        }


        Integer[] comparisonArray = Arrays.copyOf(testArray, testArray.length);

        assertEquals(Arrays.stream(testArray).min(Integer::compare).get(), PositionalStatistics.positionalStatistic(testArray, 1));
        assertEquals(Arrays.stream(testArray).max(Integer::compare).get(), PositionalStatistics.positionalStatistic(testArray, 1000));

        Integer[] sortedArray = new Integer[1000];

        for(int i = 0; i < 1000; i++) {
            sortedArray[i] = PositionalStatistics.positionalStatistic(testArray, i + 1);
        }

        Arrays.sort(comparisonArray);

        assertArrayEquals(comparisonArray, sortedArray);
    }

    @Test
    public void randomStringArrayTest() {
        String[] testArray = generateRandomStringArray(1000,50);
        String[] comparisonArray = Arrays.copyOf(testArray, testArray.length);

        assertEquals(Arrays.stream(testArray).min(CharSequence::compare).get(), PositionalStatistics.positionalStatistic(testArray, 1));
        assertEquals(Arrays.stream(testArray).max(CharSequence::compare).get(), PositionalStatistics.positionalStatistic(testArray, 1000));

        String[] sortedArray = new String[1000];

        for(int i = 0; i < 1000; i++) {
            sortedArray[i] = PositionalStatistics.positionalStatistic(testArray, i + 1);
        }

        Arrays.sort(comparisonArray);

        assertArrayEquals(comparisonArray, sortedArray);
    }

    private static Integer[] generateRandomIntegerArray(int size, int minimum, int maximum) {
        Integer[] generatedArray = new Integer[size];

        for(int i = 0; i < size; i++) {
            generatedArray[i] = minimum + random.nextInt(maximum - minimum + 1);
        }

        return generatedArray;
    }

    public static String[] generateRandomStringArray(int size, int maximumWordLength) {
        String[] result = new String[size];

        for(int i = 0; i < size; i++) {
            result[i] = generateRandomWord(maximumWordLength);
        }

        return result;
    }

    private static String generateRandomWord(int maximumLength) {
        int actualLength = 1 + random.nextInt(maximumLength);
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < actualLength; i++) {
            result.append((char)(random.nextInt(26) + 'a'));
        }

        return result.toString();
    }
}