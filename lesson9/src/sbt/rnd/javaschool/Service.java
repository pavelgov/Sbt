package sbt.rnd.javaschool;

import java.io.Serializable;

/**
 * Created by User on 20.09.2017.
 */
public interface Service  {

   @MyAnnotation(fileNamePrefix = "data", identityBy = {String.class, double.class})
    int doHardWork(String line, int value);
}
