/**
 * Created by User on 24.08.2017.
 */
public class Person {

    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }
    /**
     * Этот метод проверяет пол лица. Если они не одного пола - пытается жениться.
     * Если у одного из них второй супруг оформляет развод(наборы супруга = NULL для мужа и жены.
     Пример: если оба лица супруги - тогда развод будет установить 4 супруг в NULL), а затем выполняет жениться(). *
     @парам человек - новый муж/жена для этого человека. *
     @возвращает - возвращает True, если этот человек другого пола, чем прошел человек и они не муж и жена, и false в противном случае

      * This method checks gender of persons. If genders are not equal - tries to marry.
      * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife. Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
      * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise

    /**
     * Sets spouse = null if spouse is not null
     * @return true - if person status has been changed
     */
    public boolean marry(Person person) {

    }

    public boolean divorce() {

    }


}
