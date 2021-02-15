import java.util.Comparator;

public class QuickSort
{
    public static<T> void quickSort(T[] array, Comparator<T> comparator) {
        sort(array,0,array.length - 1, comparator);
    }

    private static<T> void sort(T[] array, int from, int to, Comparator<T> comparator) {
        if(from < to) {
            int pivot = partition(array, from, to, comparator);
            sort(array, from, pivot - 1, comparator);
            sort(array,pivot + 1, to, comparator);
        }
    }

    private static<T> int partition(T[] array, int from, int to, Comparator<T> comparator) {
        int pivot = (from + to) /2;
        swap(array,pivot,to);
        int mid = from;

        for(int i = from; i < to; i++) {
            if(comparator.compare(array[i],array[to]) < 0) {
                swap(array,i,mid);
                mid++;
            }
        }
        swap(array,mid,to);

        return mid;
    }

    private static<T> void swap(T[] array, int firstIndex, int secondIndex) {
        T tmp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp;
    }
}
