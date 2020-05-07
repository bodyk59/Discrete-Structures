package com.bogdan.kurchak.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Bogdan Kurchak
 */
public class Lab3 {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 0, 1},
                {0, 1, 1, 1, 1},
                {0, 0, 1, 0, 1},
                {0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0}
        };

        int[][] matrixTest = {
                {1, 0, 1, 0, 1},
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1}
        };

        System.out.println("Матриця:");

        for (int[] array : matrix) {
            for (int number : array) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

        printResult("Чи є матриця рефлексивною: ", Lab3::isReflexive, matrix);
        printResult("Чи є матриця антирефлексивною: ", Lab3::isAntiReflexive, matrix);
        printResult("Чи є матриця симетричною: ", Lab3::isSymmetric, matrix);
        printResult("Чи є матриця антисиметричною: ", Lab3::isAntisymmetric, matrix);
        printResult("Чи є матриця транзитивною: ", Lab3::isTransitive, matrix);
    }

    public static boolean isReflexive(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAntiReflexive(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSymmetric(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length != matrix[i].length) {
                return false;
            }

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isAntisymmetric(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length != matrix[i].length) {
                return false;
            }

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0 && matrix[j][i] != 0 && i != j) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isTransitive(int[][] matrix) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1 && i != j) {
                    list.add(List.of(i, j));
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) {
                    continue;
                }

                if (list.get(i).get(1).equals(list.get(j).get(0))
                        && matrix[list.get(i).get(0)][list.get(j).get(1)] == 0) {
                        return false;
                    }
                }
            }

        return true;
    }

    public static void printResult(String string, Predicate<int[][]> function, int[][] matrix) {
        System.out.print(string);
        System.out.println(function.test(matrix));
    }
}
