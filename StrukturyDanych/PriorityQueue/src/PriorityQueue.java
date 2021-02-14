import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PriorityQueue<T extends Comparable<T>>
{
    private ArrayList<T> queue;

    private PriorityQueue(ArrayList<T> queue) {
        this.queue = queue;
    }

    public static<T extends Comparable<T>> PriorityQueue<T> empty() {
        return new PriorityQueue<T>(new ArrayList<T>());
    }

    //Time complexity of O(1)
    public T first() {
        if(queue.isEmpty()) throw new NoSuchElementException("Priority queue: first");

        return queue.get(0);
    }

    //Time complexity of O(lgn)
    public T dequeue() {
        if(queue.isEmpty()) throw new NoSuchElementException("PriorityQueue: dequeue");

        T head = queue.get(0);
        swap(0,queue.size() - 1);
        queue.remove(queue.size() - 1);
        heapify(0);

        return head;
    }

    //Time complexity of O(lgn)
    public void increaseKey(int index, T newKey) {
        if(index >= queue.size()) throw new IndexOutOfBoundsException("Priority queue: increaseKey");
        if(queue.get(index).compareTo(newKey) > 0) throw new IllegalArgumentException("Priority queue: " + newKey);

        queue.set(index, newKey);

        while(index > 0 && queue.get(index).compareTo(queue.get(parent(index))) > 0) {
            swap(index,parent(index));
            index = parent(index);
        }
    }

    //Time complexity of O(lgn)
    public void enqueue(T key) {
        queue.add(key);
        int index = queue.size() - 1;
        while(index > 0 && queue.get(index).compareTo(queue.get(parent(index))) > 0) {
            swap(index,parent(index));
            index = parent(index);
        }
    }

    private void heapify(int index) {
        int largest = index;

        if(left(index) < queue.size() && queue.get(left(index)).compareTo(queue.get(largest)) > 0) {
            largest = left(index);
        }

        if(right(index) < queue.size() && queue.get(right(index)).compareTo(queue.get(largest)) > 0) {
            largest = right(index);
        }

        if(largest != index) {
            swap(largest,index);
            heapify(largest);
        }
    }

    private void swap(int firstIndex, int secondIndex) {
        T tmp = queue.get(firstIndex);
        queue.set(firstIndex,queue.get(secondIndex));
        queue.set(secondIndex,tmp);
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (int)(Math.floor((index - 1) / 2.0));
    }
}
