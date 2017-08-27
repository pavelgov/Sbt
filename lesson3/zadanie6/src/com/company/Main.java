package com.company;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int indexOfLine = 0;

        while (true) {
            indexOfLine = Integer.parseInt(reader.readLine());
            if (indexOfLine <= list.size() - 1 && indexOfLine >= 0) // diapozon znacheniy
                System.out.println(list.get(indexOfLine));
            else {
                System.out.println("Строки с таким номером не существует!");
                break;
            }
        }
    }
}
