import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class BucketSortTest
{
    public static final Random random = new Random();

    @Test
    public void smallArrayTest() {
        int[] testArray = generateIntArray(1000,1000);
        int[] comparisonArray = Arrays.copyOf(testArray, testArray.length);

        BucketSort.bucketSort(testArray);
        Arrays.sort(comparisonArray);

        assertArrayEquals(comparisonArray, testArray);
    }

    @Test
    public void bigArrayTest() {
        int[] testArray = generateIntArray(1000000,1000000);
        int[] comparisonArray = Arrays.copyOf(testArray, testArray.length);

        BucketSort.bucketSort(testArray);
        Arrays.sort(comparisonArray);

        assertArrayEquals(comparisonArray, testArray);
    }

    private static int[] generateIntArray(int size, int maxValue) {
        int[] generatedArray = new int[size];

        for(int i = 0; i < size; i++) {
            generatedArray[i] = random.nextInt(maxValue + 1);
        }

        return generatedArray;
    }
}