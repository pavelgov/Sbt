package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("test.txt"), StandardCharsets.UTF_8))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String words[] = line.split(" ");
                list.addAll(new ArrayList<String>(Arrays.asList(words)));
            }
        } catch (IOException e) {
            // log error
        }

        Collections.sort(list);
        Collections.sort(list, new Comparator<String> () {
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });


        System.out.println(list);

    }
}
