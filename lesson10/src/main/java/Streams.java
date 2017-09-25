import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.function.Function;
import java.util.function.*;


/**
 * Created by User on 24.09.2017.
 */
public class Streams<T> {
    private List<T> list;

    public Streams(List<T> list) {
        this.list = list;
    }

    public static <E> Streams<E> of(List<? extends E> list) {
        return new Streams(list);
    }

    public Streams<T> filter(Predicate<? super T> predicate) {
        List<T> transformList = new ArrayList<T>(list);
        for (T item : transformList) {
            if (!predicate.test(item)) {
               transformList.remove(item);
            }
        }
        return new Streams<T>(transformList);

    }

    public Streams<T> transform(Function<? super T, ? extends T> function) {
        List<T> transformList = new ArrayList<T>();

        for (T elem : list) {
            transformList.add(function.apply(elem));
        }
        return new Streams<T>(transformList);
    }

    public <K, V> Map<K, V> toMap(Function<? super T, ? extends K> key,
                                  Function<? super T, ? extends V> value) {
        HashMap<K, V> map = new HashMap<>();
        for (T elem : list) {
            map.put(key.apply(elem), value.apply(elem));
        }
        return map;
    }
}

