package sbt.rnd.javaschool;

import java.io.Serializable;

/**
 * Created by User on 20.09.2017.
 */
public class ServiceImpl implements Service {
    private String line;
    private int value;
    private int result;


    @Override
    public int doHardWork(String line, int value) {
        this.value = value;
        this.line = line;
        result = this.line.hashCode() / this.value;
        return result;
    }

}
