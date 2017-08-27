package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        int count = 0; //решение без коллекций

        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("test.txt"), StandardCharsets.UTF_8))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String words[] = line.split(" ");

                /* Решение без использования коллекций
                count += words.length;       */

                list.addAll(new ArrayList<String>(Arrays.asList(words)));
            }

        } catch (IOException e) {
            // log error
        }
        System.out.println(list.size());

    }
}
