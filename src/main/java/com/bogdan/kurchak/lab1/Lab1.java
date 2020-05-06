package com.bogdan.kurchak.lab1;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

/**
 * @author Bogdan Kurchak
 */
public class Lab1 {
    public static void main(String[] args) {
        int[] a = {8, 1, 2, 3, 6, 5};
        int[] b = {2, 9, 7, 3, 5, 1};

        System.out.println("Масив 1: " + Arrays.toString(a));
        System.out.println("Масив 2: " + Arrays.toString(b));
        System.out.println();

        printResult("Об'єднання: ", Lab1::union, a, b);
        printResult("Перетин: ", Lab1::intersection, a, b);
        printResult("Різниця: ", Lab1::difference, a, b);
        printResult("Симетрична різниця: ", Lab1::symmetricDifference, a, b);

        System.out.println("Включення: " + inclusion(a, b));
        System.out.println("Рівність: " + equal(a, b));
    }

    public static int[] union(int[] firstArray, int[] secondArray) {
        checkIfNull(firstArray);
        checkIfNull(secondArray);

        Set<Integer> integerSet = new HashSet<>();

        for (int value : firstArray) {
            integerSet.add(value);
        }

        for (int value : secondArray) {
            integerSet.add(value);
        }

        return intArrayConverter(integerSet);
    }

    public static int[] intersection(int[] firstArray, int[] secondArray) {
        checkIfNull(firstArray);
        checkIfNull(secondArray);

        Set<Integer> integerSet = new HashSet<>();

        for (int i : firstArray) {
            for (int j : secondArray) {
                if (i == j) {
                    integerSet.add(i);
                }
            }
        }

        return intArrayConverter(integerSet);
    }

    public static int[] difference(int[] firstArray, int[] secondArray) {
        checkIfNull(firstArray);
        checkIfNull(secondArray);

        Set<Integer> integerSet = new HashSet<>();

        for (int i : firstArray) {
            for (int j : secondArray) {
                if (i == j) {
                    integerSet.remove(i);
                    break;
                }
                integerSet.add(i);
            }
        }

        return intArrayConverter(integerSet);
    }

    public static int[] symmetricDifference(int[] firstArray, int[] secondArray) {
        checkIfNull(firstArray);
        checkIfNull(secondArray);

        Set<Integer> integerSet = new HashSet<>();

        int[] firstArrayDiff = difference(firstArray, secondArray);
        int[] secondArrayDiff = difference(secondArray, firstArray);

        for (int i : firstArrayDiff) {
            integerSet.add(i);
        }

        for (int i : secondArrayDiff) {
            integerSet.add(i);
        }

        return intArrayConverter(integerSet);
    }

    public static boolean inclusion(int[] firstArray, int[] secondArray) {
        checkIfNull(firstArray);
        checkIfNull(secondArray);

        for (int i = 0; i < firstArray.length; i++) {
            int finalI = i;
            if (IntStream.of(secondArray).noneMatch(x -> x == firstArray[finalI])) {
                return false;
            }
        }

        return true;
    }

    public static boolean equal(int[] firstArray, int[] secondArray) {
        checkIfNull(firstArray);
        checkIfNull(secondArray);

        return inclusion(firstArray, secondArray) && inclusion(secondArray, firstArray);
    }

    public static int[] intArrayConverter(Collection<Integer> collection) {
        return collection.stream().mapToInt(i -> i).toArray();
    }

    public static void checkIfNull(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Null value!");
        }
    }

    public static void printResult(String string, BinaryOperator<int[]> binaryOperator, int[] a, int[] b) {
        System.out.print(string);
        System.out.println(Arrays.toString(binaryOperator.apply(a, b)));
    }
}
