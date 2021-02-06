import java.lang.reflect.Array;
import java.util.Arrays;

public class Inversions
{
    private static int inversions = 0;

    private Inversions() {

    }

    public static<T extends Comparable<T>> int numberOfInversions(T[] array) {
        T[] cloneArray = Arrays.copyOf(array,array.length);
        sort(cloneArray,0,array.length - 1);
        return inversions;
    }

    private static<T extends Comparable<T>> void sort(T[] array,int from,int to) {
        if(from < to) {
            int mid = (from + to)/2;
            sort(array,from,mid);
            sort(array,mid + 1,to);
            merge(array,from,mid,to);
        }
    }

    private static<T extends Comparable<T>> void merge(T[] array,int low,int medium,int high) {
        int leftCounter = 0;
        int rightCounter = 0;
        T[] mergedSubarray = (T[])(Array.newInstance(array[0].getClass(),high - low + 1));

        while(low + leftCounter <= medium && medium + 1 + rightCounter <= high) {
            if(array[low + leftCounter].compareTo(array[medium + 1 + rightCounter]) <= 0) {
                mergedSubarray[leftCounter + rightCounter] = array[low + leftCounter];
                leftCounter++;
            }
            else {
                mergedSubarray[leftCounter + rightCounter] = array[medium + 1 + rightCounter];
                rightCounter++;
                inversions += medium - low + 1 - leftCounter;
            }
        }

        while(low + leftCounter <= medium) {
            mergedSubarray[leftCounter + rightCounter] = array[low + leftCounter];
            leftCounter++;
        }

        while(medium + 1 + rightCounter <= high) {
            mergedSubarray[leftCounter + rightCounter] = array[medium + 1 + rightCounter];
            rightCounter++;
        }

        for(int i = 0; i < mergedSubarray.length; i++) {
            array[low + i] = mergedSubarray[i];
        }
    }
}
