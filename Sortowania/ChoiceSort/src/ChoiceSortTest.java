import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class ChoiceSortTest
{
    private static Random numbersGenerator = new Random();

    @Test
    public void smallRandomIntegerTest() {
        randomIntegerTest(1000,-1000,1000);
    }

    @Test
    public void bigRandomIntegerTest() {
        randomIntegerTest(10000,-10000,10000);
    }

    private static void randomIntegerTest(int size,int min,int max) {
        Integer[] arrayToSort = generateRandomIntegerArray(size,min,max);
        Integer[] comparisonArray = Arrays.copyOf(arrayToSort,size);
        ChoiceSort.choiceSort(arrayToSort);
        Arrays.sort(comparisonArray);
        assertArrayEquals(comparisonArray,arrayToSort);
    }

    private static Integer[] generateRandomIntegerArray(int size,int min,int max) {
        Integer[] result = new Integer[size];

        for(int i = 0; i < size; i++) {
            result[i] = min + numbersGenerator.nextInt(max - min + 1);
        }

        return result;
    }
}