import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest
{
    private static Random numberGenerator = new Random();

    @Test
    public void bigRandomIntegerTest() {
        randomIntegerTest(10000,-100000,50000);
    }

    @Test
    public void smallRandomIntegerTest() {
        randomIntegerTest(1000,-500,600);
    }

    private static void randomIntegerTest(int sizeOfArray,int minimalValue,int maximalValue) {
        Integer[] arrayToSort = generateRandomIntegerArray(sizeOfArray,minimalValue,maximalValue);
        Integer[] comparisonArray = Arrays.copyOf(arrayToSort,sizeOfArray);

        BubbleSort.bubbleSort(arrayToSort);
        Arrays.sort(comparisonArray);

        assertArrayEquals(comparisonArray,arrayToSort);
    }

    private static Integer[] generateRandomIntegerArray(int size,int min,int max) {
        Integer[] result = new Integer[size];

        for(int i = 0; i < size; i++) {
            result[i] = min + numberGenerator.nextInt(max - min + 1);
        }

        return result;
    }
}