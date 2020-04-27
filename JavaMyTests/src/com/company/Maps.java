package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Maps {

    public static void main(String[] args) {
        Map <String, Integer> digitsByName = new HashMap<>();
        digitsByName.put("zero", 0);
        digitsByName.put("one", 1);
        digitsByName.put("two", 2);
        digitsByName.put("three", 3);
        digitsByName.remove("one");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

//        for (String key : digitsByName.keySet()) {
//            System.out.println(key);
//        }

        for (Map.Entry<String, Integer> entry : digitsByName.entrySet()) {
            System.out.printf("%s -> %d%n",
                    entry.getKey(), entry.getValue());
        }
    }
}
