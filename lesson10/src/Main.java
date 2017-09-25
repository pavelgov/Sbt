import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 24.09.2017.
 */
public class Main {
    public static void main(String[] args) {

        List<Person> someCollection = new ArrayList<Person>();

        someCollection.add(new Person("Геннадий", 21));
        someCollection.add(new Person("Борис", 33));
        someCollection.add(new Person("Арсений", 18));


    Map m = Streams.of(someCollection)
            .filter(p -> p.getAge() > 20)
            .transform( p -> new Person(p.geAge() + 30)))
            .toMap(p -> p.geName(), p -> p);
    }
}
