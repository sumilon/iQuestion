package com.question.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AutoCompleteDao {

    private static final List<String> strings;

    static {
        strings = new ArrayList<>();
        strings.add("OOPS concepts");
        strings.add("Exception Handling");
        strings.add("Design Pattern");
        strings.add("Java 8");
        strings.add("Java 9");
        strings.add("Streams API");
        strings.add("Java Collections");
        strings.add("Multithreading");
        strings.add("REST API");
        strings.add("Spring MVC");
        strings.add("Spring Boot");
        strings.add("JDBC");
        strings.add("Spring IOC");
        strings.add("JPA & Hibernate");
        strings.add("Spring Security");
        strings.add("Kafka Message Queue");
        strings.add("Data Structures");
        strings.add("Date and Time");
        strings.add("File System");
        strings.add("Advanced Java Programming");
        strings.add("Regular Expressions");
        strings.add("Others");

    }

    public static List<String> getStrings(final String input) {
        return strings.stream().filter(s -> s.toLowerCase().contains(input.toLowerCase())).collect(Collectors.toList());
    }
}
