package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Lecture {
        String name;
        int day;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Lecture> lectures = new ArrayList<>();

            int numLectures = scanner.nextInt();

            for (int i = 0; i < numLectures; i++) {
                String name = scanner.next();
                int day = scanner.nextInt();

                Lecture current = new Lecture();
                current.name = name;
                current.day = day;

                lectures.add(current);
            }

            int queryDay = scanner.nextInt();
            Lecture found = getLectureWithDay(lectures, queryDay);

            if (found != null) {
                System.out.println(found.name + " " + found.day);
            } else {
                System.out.println("No lecture on that day.");
            }

    }

    private static Lecture getLectureWithDay(List<Lecture> lectures, int queryDay) {
        Lecture found = null;

        for (Lecture lecture : lectures) {
            if (lecture.day == queryDay) {
                found = lecture;
                break;
            }
        }
        return found;
    }
}
