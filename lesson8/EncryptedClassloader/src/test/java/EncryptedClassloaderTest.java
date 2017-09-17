package test.java;

import org.junit.Test;
import sbt.rnd.javaschool.EncryptedClassloader;
import sbt.rnd.javaschool.Main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by User on 17.09.2017.
 */
public class EncryptedClassloaderTest {
    EncryptedClassloader encLoader =
            new EncryptedClassloader("key", new File("C:\\Sbt\\Sbt\\lesson8\\EncryptedClassloader\\src\\sbt\\rnd\\javaschool\\plugins"), Main.class.getClassLoader());


    @Test(expected = ClassFormatError.class)
    public void findClass() throws ClassFormatError, ClassNotFoundException {
        System.out.println(encLoader.loadClass(""));
    }

    @Test
    public void loadFromFile() throws IOException {
        String s = "C:\\Sbt\\Sbt\\lesson8\\EncryptedClassloader\\src\\sbt\\rnd\\javaschool\\plugins\\Plg.class";
        byte[] expected = Files.readAllBytes(Paths.get(s));
        assertArrayEquals(expected,encLoader.loadFromFile(s));

    }
    @Test(expected = IOException.class)
    public void loadFromFileIOExpected() throws IOException {
        String s = "";
        byte[] expected = Files.readAllBytes(Paths.get(s));
         encLoader.loadFromFile(s);

    }



}