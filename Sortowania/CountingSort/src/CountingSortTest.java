import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class CountingSortTest
{
    private static final Random random = new Random();

    @Test
    public void smallIntArrayTest() {
        int[] testArray = {8,6,4,5,4,1,3,2,1,7};
        int[] comparisonArray = Arrays.copyOf(testArray,testArray.length);

        CountingSort.countingSort(testArray,8);
        Arrays.sort(comparisonArray);

        assertArrayEquals(comparisonArray,testArray);
    }

    @Test
    public void bigRandomIntArrayTest() {
        int[] testArray = generateRandomIntArray(1000000,0,1000000);
        int[] comparisonArray = Arrays.copyOf(testArray,testArray.length);

        CountingSort.countingSort(testArray,1000000);
        Arrays.sort(comparisonArray);

        assertArrayEquals(comparisonArray, testArray);
    }

    public int[] generateRandomIntArray(int size, int minValue, int maxValue) {
        int[] result = new int[size];

        for(int i = 0; i < size; i++) {
            result[i] = minValue + random.nextInt(maxValue - minValue + 1);
        }

        result[size - 1] = maxValue;

        return result;
    }
}