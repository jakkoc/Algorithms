import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class RadixSortTest
{
    private static final Random random = new Random();

    @Test
    public void smallArrayTest() {
        int[] testArray = generateIntArray(1000,1000);
        int[] comparisonArray = Arrays.copyOf(testArray,testArray.length);

        RadixSort.radixSort(testArray);
        Arrays.sort(comparisonArray);
        System.out.println(Arrays.toString(testArray));

        assertArrayEquals(comparisonArray,testArray);
    }

    @Test
    public void bigArrayTest() {
        int[] testArray = generateIntArray(1000000,1000000);
        int[] comparisonArray = Arrays.copyOf(testArray,testArray.length);

        RadixSort.radixSort(testArray);
        Arrays.sort(comparisonArray);

        assertArrayEquals(comparisonArray, testArray);
    }


    private int[] generateIntArray(int size, int maxValue) {
        int[] result = new int[size];

        for(int i = 0; i < size; i++) {
            result[i] = random.nextInt(maxValue + 1);
        }

        return result;
    }
}