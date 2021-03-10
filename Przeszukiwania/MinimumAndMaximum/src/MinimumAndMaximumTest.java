import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class MinimumAndMaximumTest {
    private static final Random random = new Random();

    @Test
    public void oneElementIntegerArrayTest() {
        Integer[] testArray = {2};

        MinimumAndMaximum.Pair<Integer> pairFound = MinimumAndMaximum.findMinimumAndMaximum(testArray, Integer::compare);
        MinimumAndMaximum.Pair<Integer> comparisonPair = new MinimumAndMaximum.Pair<>(Arrays.stream(testArray).min(Integer::compare).get(), Arrays.stream(testArray).max(Integer::compare).get());

        assertEquals(comparisonPair, pairFound);
    }

    @Test
    public void smallRandomIntegerArrayTest() {
        Integer[] testArray = generateRandomIntegerArray(1000, - 2000, 1000);

        MinimumAndMaximum.Pair<Integer> pairFound = MinimumAndMaximum.findMinimumAndMaximum(testArray, Integer::compare);
        MinimumAndMaximum.Pair<Integer> comparisonPair = new MinimumAndMaximum.Pair<>(Arrays.stream(testArray).min(Integer::compare).get(), Arrays.stream(testArray).max(Integer::compare).get());

       assertEquals(comparisonPair, pairFound);
    }

    @Test
    public void bigRandomIntegerArrayTest() {
        Integer[] testArray = generateRandomIntegerArray(1000000, - 200000, 100000);

        MinimumAndMaximum.Pair<Integer> pairFound = MinimumAndMaximum.findMinimumAndMaximum(testArray, Integer::compare);
        MinimumAndMaximum.Pair<Integer> comparisonPair = new MinimumAndMaximum.Pair<>(Arrays.stream(testArray).min(Integer::compare).get(), Arrays.stream(testArray).max(Integer::compare).get());

        assertEquals(comparisonPair, pairFound);
    }

    @Test
    public void sortedIntegerArrayTest() {
        Integer[] sortedArray = new Integer[10000];

        for(int i = 0; i < 10000; i++) {
            sortedArray[i]= i;
        }

        MinimumAndMaximum.Pair<Integer> pairFound = MinimumAndMaximum.findMinimumAndMaximum(sortedArray, Integer::compare);
        MinimumAndMaximum.Pair<Integer> comparisonPair = new MinimumAndMaximum.Pair<>(Arrays.stream(sortedArray).min(Integer::compare).get(), Arrays.stream(sortedArray).max(Integer::compare).get());

        assertEquals(comparisonPair, pairFound);
    }

    @Test
    public void reverseSortedIntegerArrayTest() {
        Integer[] sortedArray = new Integer[10000];

        for(int i = 0; i < 10000; i++) {
            sortedArray[i]= 10000 - i;
        }

        MinimumAndMaximum.Pair<Integer> pairFound = MinimumAndMaximum.findMinimumAndMaximum(sortedArray, Integer::compare);
        MinimumAndMaximum.Pair<Integer> comparisonPair = new MinimumAndMaximum.Pair<>(Arrays.stream(sortedArray).min(Integer::compare).get(), Arrays.stream(sortedArray).max(Integer::compare).get());

        assertEquals(comparisonPair, pairFound);
    }

    @Test
    public void bigStringArrayTest() {
        String[] testArray = generateRandomStringArray(1000000, 50);

        MinimumAndMaximum.Pair<String> pairFound = MinimumAndMaximum.findMinimumAndMaximum(testArray, CharSequence::compare);
        MinimumAndMaximum.Pair<String> comparisonPair = new MinimumAndMaximum.Pair<>(Arrays.stream(testArray).min(CharSequence::compare).get(), Arrays.stream(testArray).max(CharSequence::compare).get());

        assertEquals(comparisonPair, pairFound);
    }

    private static Integer[] generateRandomIntegerArray(int size, int minimum, int maximum) {
        Integer[] generatedArray = new Integer[size];

        for(int i = 0; i < size; i++) {
            generatedArray[i] = minimum + random.nextInt(maximum - minimum + 1);
        }

        return generatedArray;
    }

    private static String[] generateRandomStringArray(int size, int maximumWordLength) {
        String[] generatedArray = new String[size];

        for(int i = 0; i < size; i++) {
            generatedArray[i] = generateRandomWord(maximumWordLength);
        }

        return generatedArray;
    }

    private static String generateRandomWord(int maximumLength) {
        int actualLength = random.nextInt(maximumLength) + 1;
        var generatedWord = new StringBuilder();

        for(int i = 0; i < actualLength; i++) {
            generatedWord.append((char)(random.nextInt(26) + 'a'));
        }

        return generatedWord.toString();
    }
}