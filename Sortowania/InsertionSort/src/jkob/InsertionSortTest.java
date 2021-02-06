package jkob;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortTest
{
    private static Random numbersGenerator = new Random();

    @Test
    public void smallRandomIntegerTest() {
        randomIntegerTest(100,-100,100);
    }

    @Test
    public void bigRandomIntegerTest() {
        randomIntegerTest(10000,-10000,10000);
    }

    @Test
    public void smallRandomStringTest() {
        randomStringTest(1000,50);
    }

    @Test
    public void bigRandomStringTest() {
        randomStringTest(10000,50);
    }

    private static void randomStringTest(int size,int maxLength) {
        String[] arrayToSort = randomStringArray(size,maxLength);
        String[] comparisonArray = Arrays.copyOf(arrayToSort,arrayToSort.length);
        Arrays.sort(comparisonArray);
        InsertionSort.insertionSort(arrayToSort);
        assertArrayEquals(comparisonArray,arrayToSort);
    }

    private static String[] randomStringArray(int size,int maxLength) {
        String[] stringArray = new String[size];

        for(int i = 0 ; i < size; i++) {
            stringArray[i] = generateRandomString(numbersGenerator.nextInt(maxLength) + 1);
        }

        return stringArray;
    }

    private static String generateRandomString(int length) {
        StringBuilder randomString = new StringBuilder();

        for(int i = 0; i < length; i++) {
            randomString.append((char)(97 + numbersGenerator.nextInt(26)));
        }

        return randomString.toString();
    }

    private static void randomIntegerTest(int size,int min,int max) {
        Integer[] arrayToSort = generateIntegerArray(size,min,max);
        Integer[] comparisonArray = Arrays.copyOf(arrayToSort,arrayToSort.length);
        InsertionSort.insertionSort(arrayToSort);
        Arrays.sort(comparisonArray);
        assertArrayEquals(arrayToSort,comparisonArray);
    }

    private static Integer[] generateIntegerArray(int size,int min,int max) {
        Integer[] generatedArray = new Integer[size];

        for(int i = 0; i < size; i++) {
            generatedArray[i] = min + numbersGenerator.nextInt(max - min + 1);
        }

        return generatedArray;
    }
}