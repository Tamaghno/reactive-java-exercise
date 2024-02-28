package com.tamcodes.lambdaworkshop;

public class LambdaExercise {

    public static void main(String args[]){
        Runnable lambdaOne = () -> {
            System.out.println("Hello");
        };

        AnotherClass lex = new AnotherClass(){
            public void foo(){
                System.out.println("Do something");
            }
        }; //anonoymous inner class

        lex.foo();


        ExperimentsWithLambda1 exp1 = () -> System.out.println("Ola!!");

        ExperimentsWithLambda2 exp2 = (int a, int b) -> a+b;
    }
}

interface ExperimentsWithLambda1{
    void simpleFun();
}

interface ExperimentsWithLambda2{
    int addLambda(int a, int b);
}

interface Experiment{
    public void abstractOne();

    public default void notAbstract(){
        System.out.println("NOT abstract");
    }
}
