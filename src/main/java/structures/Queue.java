package structures;

import java.util.stream.Stream;

public interface Queue<T> extends Iterable<T> {

    void enqueue(T t);

    T dequeue();

    boolean isEmpty();

    Stream<T> stream();

}
