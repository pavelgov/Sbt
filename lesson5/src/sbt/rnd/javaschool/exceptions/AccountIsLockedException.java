package sbt.rnd.javaschool.exceptions;

/**
 * Created by User on 05.09.2017.
 */
public class AccountIsLockedException extends Exception {
    public AccountIsLockedException(long message) {
        super(String.valueOf(message));
    }
}
