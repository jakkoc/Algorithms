import java.util.Arrays;

public class RadixSort
{
    public static void radixSort(int[] arrayToSort) {

        for(int i = 0; i < findLongestNumber(arrayToSort); i++)
        {
            int[] digits = new int[10];
            int[] sortedArray = new int[arrayToSort.length];

            for (int k : arrayToSort)
            {
                digits[((int)(k / Math.pow(10,i))) % 10]++;
            }

            for (int j = 1; j < digits.length; j++)
            {
                digits[j] += digits[j - 1];
            }

            for (int j = arrayToSort.length - 1; j >= 0; j--)
            {
                int digit = ((int)(arrayToSort[j] / Math.pow(10,i))) % 10;
                sortedArray[digits[digit] - 1] = arrayToSort[j];
                digits[digit]--;
            }

            System.arraycopy(sortedArray, 0, arrayToSort, 0, arrayToSort.length);
        }
    }

    private static int findLongestNumber(int[] array) {
        int maximumDigits = 0;
        int currentDigits;
        int currentNumber;


        for (int j : array)
        {
            currentNumber = j;
            currentDigits = 0;
            while (currentNumber > 0)
            {
                currentDigits++;
                currentNumber /= 10;
            }
            if (currentDigits > maximumDigits) maximumDigits = currentDigits;
        }

        return maximumDigits;
    }

    public static void main(String... args) {
        int[] arrayToSort = {1,111,11};
        radixSort(arrayToSort);
        System.out.println(Arrays.toString(arrayToSort));
    }
}
