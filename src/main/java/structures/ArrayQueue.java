package structures;

import java.rmi.ServerError;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class ArrayQueue<T> implements Queue<T> {

    private static final int INITIAL_CAPACITY = 16;
    private int capacity;
    private int head;
    private int tail;

    private T storage[];

    public ArrayQueue() {
        storage = (T[]) new Object[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
        head = 0;
        tail = 0;
    }

    @Override
    public void enqueue(T t) {
        if(tail == capacity && head <= capacity / 4) {
            resize(capacity * 2);
        } else if (head > capacity / 4) {
            //Case when there is free space at the beginning of the array
            //You have to move it all back for value of head
            for(int i = 0; i < head; ++i) {
                storage[i] = storage[i+head];
                storage[i + head] = null; //java loitering
            }
            tail = tail - head;
            head = 0;
        }
        storage[tail++] = t;
    }

    @Override
    public T dequeue() {
        if(head != tail) {
            T result = storage[head++];
            storage[head-1] = null;
            return result;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public Stream<T> stream() {
        Stream.Builder<T>  streamBuilder = Stream.builder();
        Iterator<T> iterator = new ArrayQueueIterator();
        while(iterator.hasNext()) {
            streamBuilder.add(iterator.next());
        }
        return streamBuilder.build();
//        return Arrays.stream(storage);
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayQueueIterator();
    }

    private void resize(int cap) {
        capacity = cap;
        T newStorage[] = (T[]) new Object[capacity];
        System.arraycopy(storage, head, newStorage, 0, tail-head);
        storage = newStorage;
    }

    private class ArrayQueueIterator implements Iterator<T> {

        int start = ArrayQueue.this.head;
        int end = ArrayQueue.this.tail;

        @Override
        public boolean hasNext() {
            return start != end;
        }

        @Override
        public T next() {
            return ArrayQueue.this.storage[start++];
        }
    }

}
