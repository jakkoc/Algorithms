public class CountingSort
{
    public static void countingSort(int[] array, int maxValue) {
        int[] occurences = new int[maxValue + 1];

        for(int i : array) {
            occurences[i]++;
        }

        int currentIndex = 0;

        for(int i = 0; i < array.length; i++) {
            while(currentIndex < occurences.length && occurences[currentIndex] == 0) currentIndex++;

            array[i] = currentIndex;
            occurences[currentIndex]--;
        }
    }
}
