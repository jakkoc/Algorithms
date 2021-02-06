public class BinarySearch
{
    public static<T extends Comparable<T>> int binarySearch(T[] sortedArray,T elementToFind)
    {
        return search(sortedArray,elementToFind,0,sortedArray.length - 1);
    }

    public static<T extends Comparable<T>> int search(T[] sortedArray,T elementToFind,int from,int to)
    {
        if(to - from <= 0) return -1;

        int mid = (from + to)/2;
        if(sortedArray[mid].compareTo(elementToFind) > 0) return search(sortedArray, elementToFind, from, mid - 1);
        else if(sortedArray[mid].compareTo(elementToFind) == 0) return mid;
        else return search(sortedArray,elementToFind,mid + 1, to);
    }
}
