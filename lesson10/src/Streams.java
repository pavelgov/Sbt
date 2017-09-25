import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 * Created by User on 24.09.2017.
 */
public  class Streams<T> {
    private  List<T> list;

    public Streams(List<T> list) {
        this.list = list;
    }

    public static Streams of(List list) {
        return new Streams(list);
    }

    public Streams<T> filter(Predicate<? super T> predicate) {
        for (T item : list) {
            if (!predicate.test(item)) {
                list.remove(item);
            }
        }
        return this;

    }


    public <R> Streams<R> transform(Function<? super R> function) {
        for (T elem : list) {
            list.set(list.indexOf(elem), function.apply(elem));
        }
        return this;
    }

    public <E, I> Map<E, I> toMap(Function<? super T, ? extends E> function1,
                                  Function<? super T, ? extends I> function2) {
        HashMap<E, I> map = new HashMap<>();
        for (T elem : list) {
            map.put(function1.apply(elem), function2.apply(elem));
        }
        return map;
    }
}

