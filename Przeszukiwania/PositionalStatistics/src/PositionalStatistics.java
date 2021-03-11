import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PositionalStatistics {
    private static final Random random = new Random();

    /**
     * Finds nth smallest value in the array in expected O(n) operations
     * @param array Array to find positional statistic in
     * @param n Number of elements smaller or equal to positional statistic
     * @param <T> type of objects in the array
     * @return nth positional statistic
     */
    public static<T extends Comparable<T>> T positionalStatistic(T[] array, int n) {
        return randomizedSelect(Arrays.copyOf(array, array.length), 0 , array.length - 1, n);
    }

    private static<T extends Comparable<T>> T randomizedSelect(T[] array, int from, int to, int n) {
        if(from == to) return array[from];
        int pivot = randomizedPartition(array, from, to);
        int position = pivot - from + 1;

        if(position == n) {
            return array[pivot];
        }
        else if(n < position) {
            return randomizedSelect(array, from, pivot - 1, n);
        }
        else {
            return randomizedSelect(array, pivot + 1, to, n - position);
        }
    }

    private static<T extends Comparable<T>> int randomizedPartition(T[] array, int from, int to) {
        int pivot = random.nextInt(to - from + 1) + from;
        swap(array, pivot, to);
        int split = from;

        for (int i = from;  i < to; i++) {
            if(array[i].compareTo(array[to]) < 0) {
                swap(array, i , split);
                split++;
            }
        }

        swap(array, split, to);

        return split;
    }

    /**
     * Finds nth smallest value in the array in pessimistic O(n) operations
     * @param array NotNull array containing at least n elements
     * @param n position of searched element in sorted array
     * @param <T> type of objects in array
     * @return nth smallest element
     */
    public static<T extends Comparable<T>> T nthSmallest(T[] array, int n) {
        return select(array, 0 , array.length - 1, n);
    }

    private static<T extends Comparable<T>> T select(T[] array, int from, int to, int n) {
        if(from == to) return array[from];
        int pivot = partition(array, from, to);
        int position = pivot - from + 1;

        if(position == n) {
            return array[pivot];
        }
        else if(n < position) {
            return select(array, from, pivot - 1, n);
        }
        else {
            return select(array, pivot + 1, to, n - position);
        }
    }

    private static<T extends Comparable<T>> int partition(T[] array, int from, int to) {
        int pivot = findInArray(array, medianOfMedians(Arrays.copyOf(array, array.length), from, to), from, to);
        swap(array, pivot, to);
        int split = from;

        for (int i = from;  i < to; i++) {
            if(array[i].compareTo(array[to]) < 0) {
                swap(array, i , split);
                split++;
            }
        }

        swap(array, split, to);
        return split;
    }

    private static<T extends Comparable<T>> T medianOfMedians(T[] array, int from, int to) {
        ArrayList<T> medians = new ArrayList<>();
        int numberOfElements;

        for (int i = from; i <= to; ) {
            numberOfElements = Math.min(5, to - i + 1);
            sort(array, i, i + numberOfElements - 1);
            medians.add(array[(2 * i + numberOfElements) / 2]);
            i += numberOfElements;
        }

        if (medians.size() <= 5) {
           return medians.get(medians.size() / 2);
        }

        T[] a = (T[])Array.newInstance(medians.get(0).getClass(), medians.size());

        return medianOfMedians(medians.toArray(a), 0, medians.size() - 1);
    }

    private static<T extends Comparable<T>> int findInArray(T[] array, T element, int from, int to) {
        for (int i = from; i <= to; i++) {
            if(array[i].equals(element)) return i;
        }

        return -1;
    }

    private static<T extends Comparable<T>> void sort(T[] array, int from, int to) {
        T minimum;
        int minimumIndex;

        for (int i = from; i <= to; i++) {
            minimum = array[i];
            minimumIndex = i;

            for (int j = i; j <= to; j++) {
                if(minimum.compareTo(array[j]) < 0) {
                    minimum = array[j];
                    minimumIndex = j;
                }
            }

            swap(array, i, minimumIndex);
        }
    }

    private static<T> void swap(T[] array, int currentIndex, int newIndex) {
        T tmp = array[currentIndex];
        array[currentIndex] = array[newIndex];
        array[newIndex] = tmp;
    }
}
