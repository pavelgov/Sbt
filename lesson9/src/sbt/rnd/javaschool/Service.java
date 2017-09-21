package sbt.rnd.javaschool;


/**
 * Created by User on 20.09.2017.
 */
public interface Service  {

   @MyAnnotation(fileNamePrefix = "data", identityBy = { String.class,Integer.class})
    int doHardWork(String line, int value);
}
