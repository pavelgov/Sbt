package sbt.rnd.javaschool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by User on 13.09.2017.
 */
public class EncryptedClassloader extends ClassLoader {
    private final String key;
    private final File dir;

    public EncryptedClassloader(String key, File dir, ClassLoader parent) {
        super(parent);
        this.key = key;
        this.dir = dir;
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String[] s = name.split("[.]");

        String src = dir + File.separator + s[s.length - 1] + ".class";

        byte[] b = new byte[0];
        try {
            b = loadFromFile(src); //загружаем байты из файла
        } catch (IOException e) {
            System.err.println("Ошибка загрузки файла");
        }
        System.out.println("файл загружен, размер файла " + b.length);
        b = encryptFile(b, key.getBytes()); //расшифровываем содержимое файла
        System.out.println("файл расшифрован");
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadFromFile(String path) throws IOException {
        return Files.readAllBytes(Paths.get(path));
    }

    private byte[] encryptFile(byte[] content, byte[] key) {
        byte[] res = new byte[content.length];

        for (int i = 0; i < content.length; i++) {
            res[i] = (byte) (content[i] ^ key[i % key.length]);
        }
        return res;
    }
}

