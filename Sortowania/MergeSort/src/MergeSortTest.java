import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest
{
    private static Random numberGenerator = new Random();

    @Test
    public void smallRandomIntegerTest() {
        randomIntegerTest(1000,-1000,1000);
    }

    @Test
    public void bigRandomIntegerTest() {
        randomIntegerTest(1000000,-1000000,1000000);
    }

    private static void randomIntegerTest(int size,int min,int max) {
        Integer[] arrayToSort = generateRandomIntegerArray(size,min,max);
        Integer[] comparisonArray = Arrays.copyOf(arrayToSort,size);
        MergeSort.mergeSort(arrayToSort);
        Arrays.sort(comparisonArray);
        assertArrayEquals(comparisonArray,arrayToSort);
    }

    private static Integer[] generateRandomIntegerArray(int size,int min,int max) {
        Integer[] generatedArray = new Integer[size];

        for(int i = 0 ; i < size ; i++) {
            generatedArray[i] = min + numberGenerator.nextInt(max - min + 1);
        }

        return generatedArray;
    }
}