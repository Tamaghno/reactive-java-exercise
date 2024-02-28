package io.javabrains.reactiveworkshop;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(System.out::println);
//        StreamSources.intNumbersStream().forEach(number -> System.out.println(number));
        System.out.println("***********************************");

        // Print numbers from intNumbersStream that are less than 5
//        StreamSources.intNumbersStream().forEach(number -> {if(number < 5) System.out.println(number);});
        StreamSources.intNumbersStream().filter(number -> number < 5).forEach(System.out::println );
        System.out.println("***********************************");


        StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .forEach(System.out::println);

        System.out.println("***********************************");


        // Print the second and third numbers in intNumbersStream that's greater than 5

        StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("***********************************");


        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println(
        StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .findFirst()
                .orElse(-1)
        );

        System.out.println("***********************************");


        // Print first names of all users in userStream
        StreamSources.userStream().forEach(user -> System.out.println(user.getFirstName()));

        System.out.println("***********************************");

        StreamSources.userStream()
                .map(User::getFirstName)
                .forEach(System.out::println);

        System.out.println("***********************************");


        // Print first names in userStream for users that have IDs from number stream
        StreamSources.intNumbersStream()
                .flatMap(id ->  StreamSources.userStream().filter(user -> user.getId() == id))
                .map(User::getFirstName)
                .forEach(System.out::println);

        System.out.println("***********************************");

        StreamSources.userStream().filter(userId -> StreamSources.intNumbersStream().anyMatch(number -> number == userId.getId()))
                .forEach(System.out::println);

        System.out.println("***********************************");


        List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8);

        intList.stream().forEach(number -> System.out.println(number));
        System.out.println("***********************************");
        intList.stream().filter(i -> i < 6).forEach(number -> System.out.println(number));
        System.out.println("***********************************");
        System.out.println(intList.stream().filter(i -> i < 6).collect(Collectors.toList()));


        System.out.println("***********************************");



        String names[] = {"A","B","C","D"};
        List<String> namelist = Arrays.asList("A","B","C","D");
        namelist.stream().forEach(name -> System.out.print(name+":"));

        Stream.of(namelist).forEach(name -> System.out.print(name+":"));

//        System.out.println(Stream.of(names));

    }

}
