package io.javabrains.reactiveworkshop;

import java.util.List;
import java.util.stream.Collectors;

public class StreamMethods {
    public static void main(String args[]){

        //filter(Predicate) -> predicate always returns true/false
        //
        // map(Function)

        List<Object> names = StreamSources.userStream()
                .filter(name -> name.getFirstName().endsWith("o"))
                .map(name -> name.getFirstName())
                .collect(Collectors.toList());
        System.out.println(names);


        StreamSources.intNumbersStream()
                .sorted((x,y) -> x.compareTo(y))
                .forEach(System.out::println);

        StreamSources.intNumbersStream().max((x,y) -> x.compareTo(y)).stream().forEach(System.out::println);

    }
}
