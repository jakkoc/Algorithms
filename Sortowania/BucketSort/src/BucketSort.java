import java.util.ArrayList;
import java.util.Arrays;

public class BucketSort
{
    public static void bucketSort(int[] arrayToSort) {
        double[] fractionalValues = assignFractionalValue(arrayToSort);
        ArrayList<Integer>[] arrayOfLists = new ArrayList[arrayToSort.length];



        for(int i = 0; i < arrayOfLists.length; i++) {
            arrayOfLists[i] = new ArrayList<>();
        }

        for(int i = 0; i < arrayToSort.length; i++) {
            arrayOfLists[Math.min((int)(arrayToSort.length * fractionalValues[i]),arrayToSort.length - 1)].add(arrayToSort[i]);
        }

        int index = 0;

        for(ArrayList<Integer> list : arrayOfLists) {
            list.sort(Integer::compare);

            for (Integer integer : list)
            {
                arrayToSort[index++] = integer;
            }
        }

    }

    private static double[] assignFractionalValue(int[] arrayToSort) {
        double[] fractionalValues = new double[arrayToSort.length];
        double biggestValue = findMaximumValue(arrayToSort);

        for(int i = 0; i < arrayToSort.length; i++) {
            fractionalValues[i] = arrayToSort[i] / biggestValue;
        }

        return fractionalValues;
    }

    private static int findMaximumValue(int[] array) {
        int maximumValue = Integer.MIN_VALUE;

        for(int i : array) {
            if(i > maximumValue) maximumValue = i;
        }

        return maximumValue;
    }

    public static void main(String... args) {
        int[] arrayToSort = {31,54,23,67,99,5,3,43};
        bucketSort(arrayToSort);
        System.out.println(Arrays.toString(arrayToSort));
    }
}
