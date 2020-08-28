package structures;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class ArrayStack<T> implements Stack<T>, Iterable<T> {

    private static final int INITIAL_CAPACITY = 16;
    private int capacity;
    int position = 0;

    private T storage[];

    public ArrayStack() {
        storage = (T[]) new Object[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
    }

    @Override
    public void push(T t) {
        if (position == capacity - 1) {
            resize(capacity * 2);
        }
        storage[position++] = t;
    }

    @Override
    public T pop() {
        if (position == 0) {
            return null;
        }
        if (position == capacity / 4) {  //trashing
            resize(capacity / 2);
        }
        T result = storage[--position];
        storage[position] = null;       //java loitering
        return result;
    }

    @Override
    public boolean isEmpty() {
        return position == 0;
    }

    @Override
    public int size() {
        return position;
    }

    @Override
    public Stream<T> stream() {
        return Arrays.stream(storage);
    }

    private void resize(int cap) {
        capacity = cap;
        T newStorage[] = (T[]) new Object[capacity];
        System.arraycopy(storage, 0, newStorage, 0, position);
        storage = newStorage;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {

        private int iteratorPos = ArrayStack.this.position;

        @Override
        public boolean hasNext() {
            return iteratorPos > 0;
        }

        @Override
        public T next() {
            if (iteratorPos <= 0) {
                throw new NoSuchElementException("There are no more elements!");
            }
            return ArrayStack.this.storage[--iteratorPos];
        }
    }
}
