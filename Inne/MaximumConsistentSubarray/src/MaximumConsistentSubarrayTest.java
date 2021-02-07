import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MaximumConsistentSubarrayTest
{
    private static Random numbersGenerator = new Random();


    @Test
    public void smallPositiveArrayTest() {
        int[] testArray = new int[1000];

        for(int i = 0 ; i < testArray.length; i++) {
            testArray[i] = numbersGenerator.nextInt(1000);
        }
        MaximumConsistentSubarray.Subarray expectedResult = new MaximumConsistentSubarray.Subarray(0,testArray.length - 1, Arrays.stream(testArray).sum());
        assert(MaximumConsistentSubarray.bruteMaximumConsistentSubarray(testArray).equals(expectedResult));
        assert(MaximumConsistentSubarray.divideAndConquerMaximumConsistentSubarray(testArray).equals(expectedResult));
    }

    @Test
    public void bigNegativeArrayTest() {
        int[] testArray = new int[100000];
        int maximum = Integer.MIN_VALUE;
        int index = 0;

        for(int i = 0 ; i < 100000; i++) {
            testArray[i] = -1 * numbersGenerator.nextInt(100000);

            if(testArray[i] > maximum) {
                maximum = testArray[i];
                index = i;
            }
        }

        MaximumConsistentSubarray.Subarray expectedResult = new MaximumConsistentSubarray.Subarray(index,index,maximum);
        long currentTime = System.currentTimeMillis();
        assert(MaximumConsistentSubarray.bruteMaximumConsistentSubarray(testArray).equals(expectedResult));
        System.out.println("Brute time elapsed: " + (System.currentTimeMillis() - currentTime) + " ms");
        currentTime = System.currentTimeMillis();
        assert(MaximumConsistentSubarray.divideAndConquerMaximumConsistentSubarray(testArray).equals(expectedResult));
        System.out.println("Divide and conquer time elapsed: " + (System.currentTimeMillis() - currentTime) + " ms");
        currentTime = System.currentTimeMillis();
        assert(MaximumConsistentSubarray.kedanesAlgorithm(testArray).equals(expectedResult));
        System.out.println("Kedane's algorithm time elapsed: " + (System.currentTimeMillis() - currentTime) + " ms");
    }

    @Test
    public void smallArrayTest() {
        int[] testArray = {1,2,3,-4,-5,1,2,4,-1,2,-2,5,-7,12,-3};
        MaximumConsistentSubarray.Subarray expectedResult = new MaximumConsistentSubarray.Subarray(5,13,16);
        assert(MaximumConsistentSubarray.bruteMaximumConsistentSubarray(testArray).equals(expectedResult));
        assert(MaximumConsistentSubarray.divideAndConquerMaximumConsistentSubarray(testArray).equals(expectedResult));
    }
}