package structures;

import java.util.Iterator;
import java.util.stream.Stream;

public class ListStack<T> implements Stack<T> {

    private class Node<T> {
        T element;
        Node<T> next;
    }

    private Node<T> first;
    private int size = 0;

    @Override
    public void push(T o) {
        Node<T> newNode = new Node<>();
        newNode.element = o;
        if (first != null) {
            newNode.next = first;
        }
        first = newNode;
        size++;
    }

    @Override
    public T pop() {
        if(first != null) {
            T result = first.element;
            first = first.next;
            size--;
            return result;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Stream<T> stream() {
        Stream.Builder<T> streamBuilder = Stream.builder();
        Iterator<T> iterator = new ListStackIterator();
        while(iterator.hasNext()) {
            streamBuilder.add(iterator.next());
        }
        return streamBuilder.build();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListStackIterator();
    }


    private class ListStackIterator implements Iterator<T> {

        Node<T> current = ListStack.this.first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            Node<T> result = current;
            current = current.next;
            return result.element;
        }
    }

}
