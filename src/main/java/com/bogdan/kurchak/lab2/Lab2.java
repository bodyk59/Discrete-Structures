package com.bogdan.kurchak.lab2;

import java.util.Arrays;

/**
 * @author Bogdan Kurchak
 */
public class Lab2 {
    public static void main(String[] args) {
        int[] universalSet = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] a = {8, 1, 2, 3, 6, 5};
        int[] b = {2, 9, 7, 3, 5, 1};

        final int i = decimalToBinaryConverter(universalSet, a);
        final int j = decimalToBinaryConverter(universalSet, b);
        final int and = i & j;
        final int or = i | j;
        final int xor = i ^ j;

        System.out.println("Універсвальна множина: " + Arrays.toString(universalSet));
        System.out.println("Множина 1: " + Arrays.toString(a));
        System.out.println("Множина 2: " + Arrays.toString(b));
        System.out.println("Бінарне представлення множини 1: " + Integer.toBinaryString(i));
        System.out.println("Десяткове представлення множини 1: " + i);
        System.out.println("Бінарне представлення множини 2: " + Integer.toBinaryString(j));
        System.out.println("Десяткове представлення множини 2: " + j);
        System.out.printf("%d AND %d = %d%n", i, j, and);
        System.out.printf("%d OR %d = %d%n", i, j, or);
        System.out.printf("%d XOR %d = %d%n", i, j, xor);
        System.out.println("Декартовий добуток (А х В): ");

        cartesianProduct(i, j);
    }

    public static int decimalToBinaryConverter(int[] universalSet, int[] set) {
        Arrays.sort(universalSet);
        Arrays.sort(set);

        StringBuilder result = new StringBuilder();
        int j = 0;

        for (int i : universalSet) {
            if (j < set.length && i == set[j]) {
                result.append("1");
                j++;
            } else {
                result.append("0");
            }
        }

        return Integer.parseInt(result.toString(), 2);
    }

    public static void cartesianProduct(int i, int j) {
        String[] firstNumber = Integer.toBinaryString(i).split("");
        String[] secondNumber = Integer.toBinaryString(j).split("");

        for (String s : firstNumber) {
            for (String s1 : secondNumber) {
                System.out.print(s + s1 + " ");
            }

            System.out.println();
        }
    }
}
