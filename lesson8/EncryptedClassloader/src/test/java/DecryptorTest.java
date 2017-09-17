package test.java;

import sbt.rnd.javaschool.Decryptor;
import sbt.rnd.javaschool.Plugin;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by User on 17.09.2017.
 */
public class DecryptorTest {


    @org.junit.Test
    public void decryptFile() throws Exception {
        String path = "C:\\Sbt\\Sbt\\lesson7\\EncryptedClassloader\\src\\sbt\\rnd\\javaschool\\plugins\\Plg.class";
        Decryptor d = new Decryptor();
       d.decryptFile(Paths.get(path), "key".getBytes());
    }

    @org.junit.Test(expected = IOException.class)
    public void decryptFileIOException() throws IOException {
        String path = "";
        Decryptor d = new Decryptor();
        assertTrue(d.decryptFile(Paths.get(path), "key".getBytes()));

    }

}