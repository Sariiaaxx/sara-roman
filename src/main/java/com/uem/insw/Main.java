package com.uem.insw;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Calculator calculator = new Calculator();
        calculator.multiply(2, 3); 
        System.out.println("Result: " + calculator.multiply(2, 3));
        System.out.println(calculator.concat("Hola", "Que tal?"));
        System.out.println(calculator.sum(2.5, 3.5));
        System.out.println(calculator.discount(100.0, 20.0));

       List<Double> amounts = new ArrayList<>();
        amounts.add(10.0);
        amounts.add(20.0);
        amounts.add(30.0);
        System.out.println("Total: " + calculator.calculateTotal(amounts));


    }
}

