import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomArrayList<T> implements Iterable<T> {
    private T[] array;   // Internal array to store elements
    private int size;    // Current number of elements in the list
    private static final int DEFAULT_CAPACITY = 10;

    // Constructor to initialize the array with a default capacity
    public CustomArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];  // Type-safe cast
        size = 0;
    }

    // Method to add an element to the list
    public void add(T element) {
        if (size == array.length) {
            resize();  // Resize the array when it's full
        }
        array[size++] = element;
    }

    // Method to get an element by its index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return array[index];
    }

    // Method to remove an element at a specific index
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];  // Shift elements to the left
        }
        array[--size] = null;  // Decrease size and avoid memory leak
    }

    // Method to get the current size of the list
    public int size() {
        return size;
    }

    // Method to sort the list using a comparator
    public void sort(Comparator<? super T> comparator) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    // Swap
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Iterator method that must be implemented to satisfy the Iterable interface
    @Override
    public Iterator<T> iterator() {
        return new CustomArrayListIterator();
    }

    // Private method to resize the internal array when it's full
    private void resize() {
        T[] newArray = (T[]) new Object[array.length * 2];  // Double the capacity
        System.arraycopy(array, 0, newArray, 0, size);  // Copy old array to new array
        array = newArray;
    }

    // Inner class to implement the Iterator for CustomArrayList
    private class CustomArrayListIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[currentIndex++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported.");
        }
    }
}
