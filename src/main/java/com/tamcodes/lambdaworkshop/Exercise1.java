package com.tamcodes.lambdaworkshop;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercise1 {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("Tam","Cha",12),
                new Person("Aam","Bay",13),
                new Person("Bam","Zay",13)
        );

        //sort by last name
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        Collections.sort(personList, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

        //print all elements in list
        printAll(personList);

        //print all persons having last name beginning with c
        printLastNameBeginsWithC(personList);

        printLastNameBeginsWithGeneric(personList, new Condition() {
            @Override
            public boolean conditionCheckElement(Person p) {
                return p.getFirstName().startsWith("C");
            }
        });

        printLastNameBeginsWithGeneric(personList, p -> p.getFirstName().startsWith("T"));

    }

    public static void printAll(List<Person> personList){
        System.out.println("List of all persons");
        for(Person p : personList){
            System.out.println(p);
        }
    }

    public static void printLastNameBeginsWithC(List<Person> personList){
        System.out.println("Last name with  C :");

        for (Person p : personList){
            if(p.getLastName().startsWith("C"))
                System.out.println(p.getFirstName());
        }
    }

    public static void printLastNameBeginsWithGeneric(List<Person> personList, Condition condition){
        System.out.println("Last name with <Generic> :");
        int c=0;
        for (Person p : personList){
            if(condition.conditionCheckElement(p))
            {
                c=1;
                System.out.println(p.getFirstName());
            }
        }
        if(c==0)
            System.out.println("No first name with expected letter found");
    }
}

interface Condition{
    boolean conditionCheckElement(Person p);
}
