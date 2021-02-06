import java.lang.reflect.Array;

public class MergeSort
{
    public static<T extends Comparable<T>> void mergeSort(T[] arrayToSort) {
        sort(arrayToSort,0,arrayToSort.length - 1);
    }

    private static<T extends Comparable<T>> void sort(T[] arrayToSort,int begin,int end) {
        if(begin < end) {
            int mid = (begin + end) / 2;
            sort(arrayToSort,begin,mid);
            sort(arrayToSort,mid + 1,end);
            merge(arrayToSort,begin,mid,end);
        }
    }

    private static<T extends Comparable<T>> void merge(T[] arrayToMerge,int l,int m,int h) {
        int leftCounter = 0;
        int rightCounter = 0;
        T[] mergedSubarray = (T[])(Array.newInstance(arrayToMerge[0].getClass(),h - l + 1));

        while(leftCounter < m - l + 1 && rightCounter < h - m) {
            if(arrayToMerge[l + leftCounter].compareTo(arrayToMerge[m + 1 + rightCounter]) <= 0) {
                mergedSubarray[leftCounter + rightCounter] = arrayToMerge[l + leftCounter];
                leftCounter++;
            }
            else {
                mergedSubarray[leftCounter + rightCounter] = arrayToMerge[m + 1 + rightCounter];
                rightCounter++;
            }
        }

        while(leftCounter < m - l + 1) {
            mergedSubarray[rightCounter + leftCounter] = arrayToMerge[l + leftCounter];
            leftCounter++;
        }

        while(rightCounter < h - m) {
            mergedSubarray[rightCounter + leftCounter] = arrayToMerge[m + 1 + rightCounter];
            rightCounter++;
        }

        for(int i = 0 ; i < mergedSubarray.length; i++) {
            arrayToMerge[l + i] = mergedSubarray[i];
        }

    }
}
