package sbt.rnd.javaschool;

import java.io.*;

public class Main {

    public Main() throws IOException, ClassNotFoundException {
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Service c =  new sbt.rnd.javaschool.ServiceImpl();
        CachedProxy proxy = new CachedProxy();
        c = proxy.create(Service.class, c);

        System.out.println(c.doHardWork("work1", 11));
        System.out.println(c.doHardWork("work1", 51));
        System.out.println(c.doHardWork("work1", 51));
        System.out.println(c.doHardWork("work1", 10));

    }

}
