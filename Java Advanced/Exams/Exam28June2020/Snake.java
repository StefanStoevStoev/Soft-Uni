package Exam28June2020;

import java.util.*;
import java.util.stream.Collectors;

public class Snake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String[][] matrix = new String[n][n];
        List<Integer> firstBurrows = new ArrayList<>(2);
        List<Integer> secondBurrows = new ArrayList<>(2);
        int positionSnakeCol = 0;
        int positionSnakeRow = 0;

        for (int k = 0; k < n; k++) {

            String[] input = scan.nextLine().split("");

            for (int h = 0; h < n; h++) {

                if (input[h].equals("B")) {

                    if (firstBurrows.isEmpty()) {
                        firstBurrows.add(k);
                        firstBurrows.add(h);
                    } else {
                        secondBurrows.add(k);
                        secondBurrows.add(h);
                    }

                } else if (input[h].equals("S")) {
                    positionSnakeCol = k;
                    positionSnakeRow = h;
                }
            }
            matrix[k] = input;
        }

        String direction = scan.nextLine();
        int food = 0;
        while (true) {
            switch (direction) {
                case "left":
                    if (positionSnakeRow - 1 >= 0) {
                        if (matrix[positionSnakeCol][positionSnakeRow - 1].equals("*")) {
                            food += 1;
                        }

                        if (matrix[positionSnakeCol][positionSnakeRow - 1].equals("B")) {
                            matrix = takeNewMatrix(matrix, positionSnakeCol, positionSnakeRow, firstBurrows, secondBurrows, direction);
                            if (positionSnakeCol == firstBurrows.get(0) && positionSnakeRow - 1 == firstBurrows.get(1)) {
                                positionSnakeCol = secondBurrows.get(0);
                                positionSnakeRow = secondBurrows.get(1);
                                secondBurrows.remove(0);
                                secondBurrows.remove(0);
                            } else {
                                positionSnakeCol = firstBurrows.get(0);
                                positionSnakeRow = firstBurrows.get(1);
                                firstBurrows.remove(0);
                                firstBurrows.remove(0);
                            }

                        } else {
                            matrix = takeNewMatrix(matrix, positionSnakeCol, positionSnakeRow, firstBurrows, secondBurrows, direction);
                            positionSnakeRow -= 1;
                        }
                    } else {

                        if (food > 9) {
                            System.out.println("You won! You fed the snake.");
                            System.out.printf("Food eaten: %d%n", food);
                            printMatrix(matrix);
                            return;
                        }
                        System.out.println("Game over!");
                        System.out.printf("Food eaten: %d%n", food);
                        matrix[positionSnakeCol][positionSnakeRow] = ".";
                        printMatrix(matrix);
                        return;
                    }
                    break;
                case "right":
                    if (positionSnakeRow + 1 < n) {
                        if (matrix[positionSnakeCol][positionSnakeRow + 1].equals("*")) {
                            food += 1;
                        }

                        if (matrix[positionSnakeCol][positionSnakeRow + 1].equals("B")) {
                            matrix = takeNewMatrix(matrix, positionSnakeCol, positionSnakeRow, firstBurrows, secondBurrows, direction);
                            if (positionSnakeCol == firstBurrows.get(0) && positionSnakeRow + 1 == firstBurrows.get(1)) {
                                positionSnakeCol = secondBurrows.get(0);
                                positionSnakeRow = secondBurrows.get(1);
                                secondBurrows.remove(0);
                                secondBurrows.remove(0);
                            } else {
                                positionSnakeCol = firstBurrows.get(0);
                                positionSnakeRow = firstBurrows.get(1);
                                firstBurrows.remove(0);
                                firstBurrows.remove(0);
                            }
                        } else {
                            matrix = takeNewMatrix(matrix, positionSnakeCol, positionSnakeRow, firstBurrows, secondBurrows, direction);
                            positionSnakeRow += 1;
                        }

                    } else {

                        if (food > 9) {
                            System.out.println("You won! You fed the snake.");
                            System.out.printf("Food eaten: %d%n", food);
                            printMatrix(matrix);
                            return;
                        }
                        System.out.println("Game over!");
                        System.out.printf("Food eaten: %d%n", food);
                        matrix[positionSnakeCol][positionSnakeRow] = ".";
                        printMatrix(matrix);
                        return;
                    }
                    break;
                case "up":
                    if (positionSnakeCol - 1 < n) {
                        if (matrix[positionSnakeCol - 1][positionSnakeRow].equals("*")) {
                            food += 1;
                        }
                        if (matrix[positionSnakeCol - 1][positionSnakeRow].equals("B")) {
                            matrix = takeNewMatrix(matrix, positionSnakeCol, positionSnakeRow, firstBurrows, secondBurrows, direction);
                            if (positionSnakeCol - 1 == firstBurrows.get(0) && positionSnakeRow == firstBurrows.get(1)) {
                                positionSnakeCol = secondBurrows.get(0);
                                positionSnakeRow = secondBurrows.get(1);
                                secondBurrows.remove(0);
                                secondBurrows.remove(0);
                            } else {
                                positionSnakeCol = firstBurrows.get(0);
                                positionSnakeRow = firstBurrows.get(1);
                                firstBurrows.remove(0);
                                firstBurrows.remove(0);
                            }
                        } else {
                            matrix = takeNewMatrix(matrix, positionSnakeCol, positionSnakeRow, firstBurrows, secondBurrows, direction);
                            positionSnakeCol -= 1;
                        }

                    } else {

                        if (food > 9) {
                            System.out.println("You won! You fed the snake.");
                            System.out.printf("Food eaten: %d%n", food);
                            printMatrix(matrix);
                            return;
                        }
                        System.out.println("Game over!");
                        System.out.printf("Food eaten: %d%n", food);
                        matrix[positionSnakeCol][positionSnakeRow] = ".";
                        printMatrix(matrix);
                        return;
                    }
                    break;
                case "down":
                    if (positionSnakeCol + 1 < n) {
                        if (matrix[positionSnakeCol + 1][positionSnakeRow].equals("*")) {
                            food += 1;
                        }

                        if (matrix[positionSnakeCol + 1][positionSnakeRow].equals("B")) {///////////////////////
                            matrix = takeNewMatrix(matrix, positionSnakeCol, positionSnakeRow, firstBurrows, secondBurrows, direction);
                            if (positionSnakeCol + 1 == firstBurrows.get(0) && positionSnakeRow == firstBurrows.get(1)) {
                                positionSnakeCol = secondBurrows.get(0);
                                positionSnakeRow = secondBurrows.get(1);
                                secondBurrows.remove(0);
                                secondBurrows.remove(0);
                            } else {
                                positionSnakeCol = firstBurrows.get(0);
                                positionSnakeRow = firstBurrows.get(1);
                                firstBurrows.remove(0);
                                firstBurrows.remove(0);
                            }
                        } else {
                            matrix = takeNewMatrix(matrix, positionSnakeCol, positionSnakeRow, firstBurrows, secondBurrows, direction);
                            positionSnakeCol += 1;
                        }
                    } else {

                        if (food > 9) {
                            System.out.println("You won! You fed the snake.");
                            System.out.printf("Food eaten: %d%n", food);
                            printMatrix(matrix);
                            return;
                        }
                        System.out.println("Game over!");
                        System.out.printf("Food eaten: %d%n", food);
                        matrix[positionSnakeCol][positionSnakeRow] = ".";
                        printMatrix(matrix);
                        return;
                    }
                    break;
            }
            if (food > 9) {
                System.out.println("You won! You fed the snake.");
                System.out.printf("Food eaten: %d%n", food);
                printMatrix(matrix);
                return;
            }
            direction = scan.nextLine();
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            System.out.println(Arrays.stream(strings).map(Objects::toString).collect(Collectors.joining("")));
        }
    }

    private static String[][] takeNewMatrix(String[][] matrix, int positionSnakeCol, int positionSnakeRow,
                                            List<Integer> firstBurrows, List<Integer> secondBurrows, String direction) {
        switch (direction) {
            case "left":

                if (matrix[positionSnakeCol][positionSnakeRow - 1].equals("B")) {
                    matrix = matrixTakeSFromBRowLeft(matrix, positionSnakeRow, positionSnakeCol, firstBurrows, secondBurrows);

                } else {
                    matrix[positionSnakeCol][positionSnakeRow] = ".";
                    matrix[positionSnakeCol][positionSnakeRow - 1] = "S";
                }

                break;
            case "right":
                if (matrix[positionSnakeCol][positionSnakeRow + 1].equals("B")) {
                    matrix = matrixTakeSFromBRowRight(matrix, positionSnakeRow, positionSnakeCol, firstBurrows, secondBurrows);
                } else {
                    matrix[positionSnakeCol][positionSnakeRow] = ".";
                    matrix[positionSnakeCol][positionSnakeRow + 1] = "S";
                }
                break;
            case "up":
                if (matrix[positionSnakeCol - 1][positionSnakeRow].equals("B")) {
                    matrix = matrixTakeSFromBRowUp(matrix, positionSnakeRow, positionSnakeCol, firstBurrows, secondBurrows);
                } else {
                    matrix[positionSnakeCol][positionSnakeRow] = ".";
                    matrix[positionSnakeCol - 1][positionSnakeRow] = "S";
                }
                break;
            case "down":
                if (matrix[positionSnakeCol + 1][positionSnakeRow].equals("B")) {
                    matrix = matrixTakeSFromBRowDown(matrix, positionSnakeRow, positionSnakeCol, firstBurrows, secondBurrows);
                } else {
                    matrix[positionSnakeCol][positionSnakeRow] = ".";
                    matrix[positionSnakeCol + 1][positionSnakeRow] = "S";
                }
                break;
        }
        return matrix;
    }

    private static String[][] matrixTakeSFromBRowDown(String[][] matrix, int positionSnakeRow, int positionSnakeCol, List<Integer> firstBurrows, List<Integer> secondBurrows) {
        if (positionSnakeCol + 1 == firstBurrows.get(0) && positionSnakeRow == firstBurrows.get(1)) {
            matrix[secondBurrows.get(0)][secondBurrows.get(1)] = "S";
        } else {
            matrix[firstBurrows.get(0)][firstBurrows.get(1)] = "S";
        }
        matrix[positionSnakeCol][positionSnakeRow] = ".";
        matrix[positionSnakeCol + 1][positionSnakeRow] = ".";
        return matrix;
    }

    private static String[][] matrixTakeSFromBRowUp(String[][] matrix, int positionSnakeRow, int positionSnakeCol, List<Integer> firstBurrows, List<Integer> secondBurrows) {

        if (positionSnakeCol - 1 == firstBurrows.get(0) && positionSnakeRow == firstBurrows.get(1)) {
            matrix[secondBurrows.get(0)][secondBurrows.get(1)] = "S";
        } else {
            matrix[firstBurrows.get(0)][firstBurrows.get(1)] = "S";
        }
        matrix[positionSnakeCol][positionSnakeRow] = ".";
        matrix[positionSnakeCol - 1][positionSnakeRow] = ".";
        return matrix;
    }

    private static String[][] matrixTakeSFromBRowRight(String[][] matrix, int positionSnakeRow, int positionSnakeCol, List<Integer> firstBurrows, List<Integer> secondBurrows) {

        if (positionSnakeCol == firstBurrows.get(0) && positionSnakeRow + 1 == firstBurrows.get(1)) {
            matrix[secondBurrows.get(0)][secondBurrows.get(1)] = "S";
        } else {
            matrix[firstBurrows.get(0)][firstBurrows.get(1)] = "S";
        }
        matrix[positionSnakeCol][positionSnakeRow] = ".";
        matrix[positionSnakeCol][positionSnakeRow + 1] = ".";
        return matrix;
    }

    private static String[][] matrixTakeSFromBRowLeft(String[][] matrix, int positionSnakeRow, int positionSnakeCol, List<Integer> firstBurrows, List<Integer> secondBurrows) {

        if (positionSnakeCol == firstBurrows.get(0) && positionSnakeRow - 1 == firstBurrows.get(1)) {
            matrix[secondBurrows.get(0)][secondBurrows.get(1)] = "S";
        } else {
            matrix[firstBurrows.get(0)][firstBurrows.get(1)] = "S";
        }
        matrix[positionSnakeCol][positionSnakeRow] = ".";
        matrix[positionSnakeCol][positionSnakeRow - 1] = ".";

        return matrix;
    }
}
