package jkob;

public class InsertionSort
{
    /**
     * @author Jakub Kochanski
     * @param arrayToSort Array to sort in ascending order
     * @param <T> type of data to sort
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public static<T extends Comparable<T>> void insertionSort(T[] arrayToSort) {
        for(int i = 1; i < arrayToSort.length; i++) {
            T key = arrayToSort[i];
            int j = i - 1;
            while(j >= 0 && key.compareTo(arrayToSort[j]) < 0) {
                arrayToSort[j + 1] = arrayToSort[j];
                j--;
            }
            arrayToSort[j + 1] = key;
        }
    }
}
