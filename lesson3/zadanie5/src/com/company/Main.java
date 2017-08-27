package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

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

        ListIterator<String> listIter = list.listIterator(list.size());

        // пройдемся по элементам в обратном порядке
        while(listIter.hasPrevious()){

            System.out.println(listIter.previous());
        }
    }
}
