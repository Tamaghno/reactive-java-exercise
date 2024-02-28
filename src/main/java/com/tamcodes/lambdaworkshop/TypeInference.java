package com.tamcodes.lambdaworkshop;

public class TypeInference {

    public static void main(String[] args) {

        StringLengthLambda lambdafun = s -> s + s.length();

        System.out.println(lambdafun.getLengthAndString("this is an exmaple of typeinference -> "));


        // passing a lambda expression
        notmain(s -> s+s.length());
    }

    public static void notmain(StringLengthLambda sll){
        System.out.println(sll.getLengthAndString("Hello World -> "));
    }
}


// this one below is a FUNCTIONAL INTERFACE -> only ONE abstract method
@FunctionalInterface
interface StringLengthLambda{
    String getLengthAndString(String s);

//    String yummy(String s);  //CANNOT ADD ANYMORE METHODS

    public default void sinmplePrint(){
        System.out.println("haha");
    }
}
