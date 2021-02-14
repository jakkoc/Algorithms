import java.util.Random;

public class RandomSearch
{
    private static final Random random = new Random();

    public static<T extends Comparable<T>> int randomSearch(T element, T[] array) {
        boolean[] wasChecked = new boolean[array.length];
        int checked = 0;
        int randomIndex;

        while(checked != array.length) {
            randomIndex = random.nextInt(array.length);

            if(!wasChecked[randomIndex]) {
                checked++;
                if(element.compareTo(array[randomIndex]) == 0) return randomIndex;
            }
        }

        return -1;
    }
}
