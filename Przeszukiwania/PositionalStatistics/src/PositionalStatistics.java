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

    private static<T> void swap(T[] array, int currentIndex, int newIndex) {
        T tmp = array[currentIndex];
        array[currentIndex] = array[newIndex];
        array[newIndex] = tmp;
    }
}
