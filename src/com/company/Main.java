package com.company;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Human> humans = List.of(
                new Human(24, "Ivan", "Ivanov", LocalDate.of(1997, 1, 1), 70),
                new Human(18, "Paul", "McCartney", LocalDate.of(2003, 3, 10), 120),
                new Human(20, "Jhon", "Lennon", LocalDate.of(2001, 7, 22), 130),
                new Human(60, "Victor", "Tsoy", LocalDate.of(1961, 5, 18), 60),
                new Human(71, "Victor", "Tsoy", LocalDate.of(1950, 9, 14), 95)
        );

        String humanNames = humans.stream()
                .sorted(Comparator.comparing(Human::getBirthDate))
                    .peek(System.out::println)
                .filter(human -> human.getAge() < 50)
                    .peek(System.out::println)
                .sorted(Comparator.comparing(Human::getWeight))
                    .peek(System.out::println)
                .map(Human::getFirstName)
                    .peek(System.out::println)
                .collect(Collectors.joining(" "));

        System.out.println(humanNames);

    }
}
