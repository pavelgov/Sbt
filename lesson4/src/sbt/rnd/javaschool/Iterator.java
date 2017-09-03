package sbt.rnd.javaschool;

/**
 * Created by User on 31.08.2017.
 */
public interface Iterator<T> {
    T next();

    boolean hasNext();

    void remove();
}
