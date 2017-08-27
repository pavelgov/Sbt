package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : list) {
            int count = 0;
            if (map.containsKey(s)) {
                count = map.get(s);
                map.put(s, ++count);
            } else map.put(s, ++count);
        }
        System.out.println(map);
    }
}
