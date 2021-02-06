public class BubbleSort
{
    public static<T extends Comparable<T>> void bubbleSort(T[] arrayToSort) {
        for(int i = 0; i < arrayToSort.length; i++) {
            for(int j = 0; j < arrayToSort.length - 1 - i; j++) {
                if(arrayToSort[j].compareTo(arrayToSort[j + 1]) > 0) swap(arrayToSort,j,j + 1);
            }
        }
    }

    private static<T extends Comparable<T>> void swap(T[] array,int firstIndex,int secondIndex) {
        T tmp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp;
    }
}
