package structures;

import java.util.stream.Stream;

public interface Stack<T> extends Iterable<T> {

    void push(T t);

    T pop();

    boolean isEmpty();

    int size();

    Stream<T> stream();

}