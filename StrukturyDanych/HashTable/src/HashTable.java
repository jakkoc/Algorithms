import java.util.Collection;
import java.util.LinkedList;

public class HashTable<T> {
    private LinkedList<T>[] array;

    public HashTable(int size) {
        array = (LinkedList<T>[])new LinkedList[size];

        for(int i = 0; i < size; i++) {
            array[i] = new LinkedList<>();
        }
    }

    public void insertAll(Collection<T> values) {
        for (var value : values) {
            insert(value);
        }
    }

    public void insert(T value) {
        var key = Math.abs(value.hashCode());

        array[key % array.length].add(value);
    }

    public void delete(T value) {
        var key = Math.abs(value.hashCode()) % array.length;

        array[key].remove(value);
    }

    public LinkedList<T> search(int key) {
        return array[Math.abs(key % array.length)];
    }
}
