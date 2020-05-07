package com.bogdan.kurchak.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Bogdan Kurchak
 */
public class Lab4 {
    public static void main(String[] args) {
        int a = 341;
        int b = 241;

        System.out.printf("Числа: %d, %d%n", a, b);
        System.out.println("НСД: " + theLargestCommonDivisor(a, b));
        System.out.println("НСК: " + leastCommonMultiple(a, b));
        printList("Прості співмножники " + a + ": ", Lab4::simpleFactors, a);
        printList("Прості співмножники " + b + ": ", Lab4::simpleFactors, b);
        printList("Дільники " + a + ": ", Lab4::dividers, a);
        printList("Дільники " + b + ": ", Lab4::dividers, b);
        printList("Ряд простих чисел до " + a + ":",
                Lab4::chainOfPrimeNumbers, a);
        printList("Ряд простих чисел до " + b + ":",
                Lab4::chainOfPrimeNumbers, b);
        printList("Mодулі, за якими два натуральні числа конгруентні:",
                Lab4::modulesOfCongruentNumbers, a, b);
    }

    public static int theLargestCommonDivisor(int a, int b) {
        int result = 1;

        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                result = i;
            }
        }

        return result;
    }

    public static int leastCommonMultiple(int a, int b) {
        return (a * b) / theLargestCommonDivisor(a, b);
    }

    public static List<Integer> simpleFactors(int number) {
        List<Integer> result = new ArrayList<>();

        for (int i = 2; i <= number; i++) {
            while(number % i == 0) {
                result.add(i);
                number /= i;
            }
        }

        return result;
    }

    public static List<Integer> dividers(int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> chainOfPrimeNumbers(int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            int counter = 0;

            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    counter++;
                }
            }

            if (counter == 2) {
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> modulesOfCongruentNumbers(int a, int b) {
        List<Integer> result = new ArrayList<>();
        int difference = a - b;

        for (int i = 1; i <= 100; i++) {
            if (difference % i == 0) {
                result.add(i);
            }
        }

        return result;
    }

    public static <T extends List<Integer>>void printList(String title,
                                 BiFunction<Integer, Integer, T> biFunction,
                                 int a,
                                 int b) {
        List<Integer> list = biFunction.apply(a, b);
        printListHelper(title, list);
    }

    public static <T extends List<Integer>>void printList(String title,
                                 Function<Integer, T> function,
                                 int a) {
        List<Integer> list = function.apply(a);
        printListHelper(title, list);
    }

    private static void printListHelper(String title,
                                        List<?> list) {
        System.out.println(title);

        for (int i = 0; i < list.size(); i++) {
            if (i != 0 && i % 10 == 0) {
                System.out.println();
            }
            System.out.print(list.get(i) + " ");
        }

        System.out.println();
    }
}
