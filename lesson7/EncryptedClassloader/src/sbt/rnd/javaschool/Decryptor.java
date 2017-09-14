package sbt.rnd.javaschool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by User on 13.09.2017.
 */
public class Decryptor {

    public void decryptFile(Path path, byte[] key) throws IOException {
        byte[] b = Files.readAllBytes(path);
        byte[] res = new byte[b.length];

        for (int i = 0; i < b.length; i++) {
            res[i] = (byte) (b[i] ^ key[i % key.length]);
        }
        Files.write(path, res);
        System.out.println("Файл зашифрован");
    }
}
