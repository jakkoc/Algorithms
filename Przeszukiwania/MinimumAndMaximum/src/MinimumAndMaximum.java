import java.util.Comparator;

public class MinimumAndMaximum {
    /**
     * This algorithm can find both maximum and minimum in 3 * floor(n/2) operations
     * @param array NotNull array of generic type containing at least one element
     * @param comparator Comparator of array objects
     * @param <T> specifies type of array objects
     * @return pair of minimum and maximum element found in the array;
     */
    public static <T> Pair<T> findMinimumAndMaximum(T[] array, Comparator<T> comparator) {
        if(array == null || array.length == 0) throw new IllegalArgumentException("No elements found in array!");
        Pair<T> minimumAndMaximum;

        if(array.length % 2 == 0) {
            minimumAndMaximum = order(array[0], array[1], comparator);
        }
        else {
            minimumAndMaximum = new Pair<>(array[0], array[0]);
        }

        for (int i = 0; i < array.length - 1; i++) {
            var currentPair = order(array[i], array[i + 1], comparator);
            minimumAndMaximum.first = order(currentPair.first, minimumAndMaximum.first, comparator).first;
            minimumAndMaximum.second = order(currentPair.second, minimumAndMaximum.second, comparator).second;
        }

        return minimumAndMaximum;
    }

    private static <T> Pair<T> order(T first, T second, Comparator<T> comparator) {
        if(comparator.compare(first, second) > 0) return new Pair<>(second, first);
        return new Pair<>(first, second);
    }

    static class Pair<T>{
        private T first;
        private T second;

        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public T getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
           if(!o.getClass().equals(getClass())) return false;

           Pair<T> pair = (Pair<T>) o;

           return first.equals(pair.first) && second.equals(pair.second);
        }

        @Override
        public String toString() {
            return first.toString() + " " + second.toString();
        }
    }
}
