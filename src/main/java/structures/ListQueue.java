package structures;

import java.util.Iterator;
import java.util.stream.Stream;

public class ListQueue<T> implements Queue<T> {

    private class Node<T> {
        T data;
        Node<T> next;
    }

    private Node<T> first;
    private Node<T> current;

    @Override
    public void enqueue(T t) {
        Node<T> newNode = new Node<>();
        newNode.data = t;
        if(first == null) {
            first = newNode;
            current = first;
        } else {
            current.next = newNode;
            current = current.next;
        }
    }

    @Override
    public T dequeue() {
        if(first != null) {
            T result = first.data;
            first = first.next;
            return result;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Stream<T> stream() {
        Stream.Builder<T>  streamBuilder = Stream.builder();
        Iterator<T> iterator = new ListQueueIterator();
        while(iterator.hasNext()) {
            streamBuilder.add(iterator.next());
        }
        return streamBuilder.build();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListQueueIterator();
    }

    private class ListQueueIterator implements Iterator<T> {

        Node<T> head = ListQueue.this.first;

        @Override
        public boolean hasNext() {
            return head != null;
        }

        @Override
        public T next() {
            T result = head.data;
            head = head.next;
            return result;
        }

    }

}
