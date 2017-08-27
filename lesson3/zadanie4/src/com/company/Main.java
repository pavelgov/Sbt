package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("test.txt"), StandardCharsets.UTF_8))) {
            String line;

            while ((line = reader.readLine()) != null) {

                list.add(line);
            }
        } catch (IOException e) {
            // log error
        }
        Collections.reverse(list);

        for (String s : list) {
            System.out.println(s);
        }
    }
}
