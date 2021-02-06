public class ChoiceSort
{
    public static<T extends Comparable<T>> void choiceSort(T[] arrayToSort) {
        T smallestValue;
        int index;
        for(int i = 0; i < arrayToSort.length - 1; i++) {
            smallestValue = arrayToSort[i];
            index = i;
            for(int j = i; j < arrayToSort.length; j++) {
                if(smallestValue.compareTo(arrayToSort[j]) > 0) {
                    smallestValue = arrayToSort[j];
                    index = j;
                }
            }
            arrayToSort[index] = arrayToSort[i];
            arrayToSort[i] = smallestValue;
        }
    }
}
