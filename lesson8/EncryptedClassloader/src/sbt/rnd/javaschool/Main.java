package sbt.rnd.javaschool;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {

      /*
      // шифруем файл
        new Decryptor().decryptFile(Paths.get("C:\\Sbt\\Sbt\\lesson7\\EncryptedClassloader\\src\\sbt\\rnd\\javaschool\\plugins\\Plg.class"),"key".getBytes());
      */

        EncryptedClassloader encLoader = new EncryptedClassloader("key", new File("C:\\Sbt\\Sbt\\lesson8\\EncryptedClassloader\\src\\sbt\\rnd\\javaschool\\plugins"), Main.class.getClassLoader());
        Class<?> claz = encLoader.loadClass("sbt.rnd.javaschool.plugins.Plg");
        Plugin plugin = (Plugin) claz.newInstance();
        plugin.doUsefull();
    }
}
