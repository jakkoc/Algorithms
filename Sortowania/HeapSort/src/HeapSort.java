public class HeapSort
{
    private static int heapSize;

    public static<T extends Comparable<T>> void maxHeapSort(T[] arrayToSort) {
        heapSize = arrayToSort.length;
        buildMaxHeap(arrayToSort);
        for(int i = arrayToSort.length; i >= 2; i--) {
            swap(arrayToSort,0,heapSize - 1);
            heapSize = heapSize - 1;
            maxHeapify(arrayToSort,0);
        }
    }

    public static<T extends Comparable<T>> void minHeapSort(T[] arrayToSort) {
        heapSize = arrayToSort.length;
        buildMinHeap(arrayToSort);
        for(int i = arrayToSort.length; i >= 2; i--) {
            swap(arrayToSort,heapSize - 1, 0);
            heapSize = heapSize - 1;
            minHeapify(arrayToSort,0);
        }
    }

    private static<T extends Comparable<T>> void buildMaxHeap(T[] arrayToSort) {
        for(int i = (int) Math.floor(arrayToSort.length / 2.0); i >= 0; i--) {
            maxHeapify(arrayToSort,i);
        }
    }

    private static<T extends Comparable<T>> void buildMinHeap(T[] arrayToSort) {
        for(int i = (int) Math.floor(arrayToSort.length / 2.0); i >= 0; i--) {
            minHeapify(arrayToSort,i);
        }
    }

    private static<T extends Comparable<T>> void maxHeapify(T[] arrayToSort, int index) {
        int largest = index;

        if(left(index) < heapSize && arrayToSort[left(index)].compareTo(arrayToSort[largest]) > 0) {
            largest = left(index);
        }

        if(right(index) < heapSize && arrayToSort[right(index)].compareTo(arrayToSort[largest]) > 0) {
            largest = right(index);
        }

        if(largest != index) {
            swap(arrayToSort,index,largest);
            maxHeapify(arrayToSort,largest);
        }
    }

    private static<T extends Comparable<T>> void iterativeMaxHeapify(T[] arrayToSort,int index) {
        int largest = index;

        while (largest <= (int) Math.floor(heapSize) / 2.00)
        {
            if (left(index) < heapSize && arrayToSort[left(index)].compareTo(arrayToSort[largest]) > 0)
            {
                largest = left(index);
            }
            if (right(index) < heapSize && arrayToSort[right(index)].compareTo(arrayToSort[largest]) > 0)
            {
                largest = right(index);
            }

            if (largest != index)
            {
                swap(arrayToSort, largest, index);
            }
        }
    }

    private static<T extends Comparable<T>> void minHeapify(T[] arrayToSort, int index) {
        int smallest = index;

        if(left(index) < heapSize && arrayToSort[left(index)].compareTo(arrayToSort[smallest]) < 0) {
            smallest = left(index);
        }
        if(right(index) < heapSize && arrayToSort[right(index)].compareTo(arrayToSort[smallest]) < 0) {
            smallest = right(index);
        }

        if(smallest != index) {
            swap(arrayToSort,index,smallest);
            minHeapify(arrayToSort,smallest);
        }
    }

    private static<T extends Comparable<T>> void swap(T[] array, int firstIndex, int secondIndex) {
        T tmp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tmp;
    }

    private static int parent(int index) {
        return (int)Math.floor((index - 1) / 2.0);
    }

    private static int left(int index) {
        return 2 * index + 1;
    }

    private static int right(int index) {
        return 2 * index + 2;
    }
}
