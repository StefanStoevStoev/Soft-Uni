package Exam22Feb2020;

import java.util.Scanner;

public class ReVolt2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int count = Integer.parseInt(scan.nextLine());

        String[][] matrix = new String[n][n];

        int fRow = 0;
        int fCol = 0;

        int gFRow = 0;
        int gFCol = 0;
        for (int row = 0; row < n; row++) {
            String[] array = scan.nextLine().split("");
            matrix[row] = array;
            for (int k = 0; k < array.length; k++) {

                if (matrix[row][k].equals("f")) {
                    fRow = row;
                    fCol = k;
                } else if (matrix[row][k].equals("F")) {
                    gFRow = row;
                    gFCol = k;
                }
            }
        }
        for (int k = 0; k < count; k++) {
            String token = scan.nextLine();

            if (token.equals("right") || token.equals("left")) {
                fCol = takeDirection(matrix, token, fRow, fCol, n);
            } else {
                fRow = takeDirection(matrix, token, fRow, fCol, n);
            }
            matrix[fRow][fCol] = "f";

            if (fRow == gFRow && fCol == gFCol) {
                System.out.println("Player won!");
                printMatrix(matrix);
                return;
            }
        }
        System.out.println("Player lost!");
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (int k = 0; k < strings.length; k++) {
                System.out.print(strings[k]);
            }
            System.out.println();
        }
    }

    private static int takeDirection(String[][] matrix, String token, int fRow, int fCol, int n) {
        switch (token) {
            case "up":
                fRow = fRow - 1;
                matrix[fRow + 1][fCol] = "-";
                if (fRow >= 0) {

                    if (matrix[fRow][fCol].equals("B")) {
                        fRow = takeDirection(matrix, token, fRow, fCol, n);
                        if (fRow == n - 1) {
                            matrix[0][fCol] = "B";
                        } else {
                            matrix[fRow + 1][fCol] = "B";
                        }

                    } else if (matrix[fRow][fCol].equals("T")) {
                        fRow = fRow + 1;
                    } else if (matrix[fRow][fCol].equals("F")) {
                        return fRow;
                    } else {
                        matrix[fRow][fCol] = "-";
                    }

                } else {
                    fRow = n - 1;
                    if (matrix[fRow][fCol].equals("B")) {
                        fRow = fRow - 1;
                        matrix[fRow + 1][fCol] = "B";
                    } else if (matrix[fRow][fCol].equals("T")) {
                        fRow = 0;
                    }
                    matrix[fRow][fCol] = "-";
                    return fRow;
                }
                break;
            case "down":
                fRow = fRow + 1;
                matrix[fRow - 1][fCol] = "-";
                if (fRow < n) {

                    if (matrix[fRow][fCol].equals("B")) {
                        fRow = takeDirection(matrix, token, fRow, fCol, n);
                        if (fRow == 0) {
                            matrix[n - 1][fCol] = "B";
                        } else {
                            matrix[fRow - 1][fCol] = "B";
                        }

                    } else if (matrix[fRow][fCol].equals("T")) {
                        return fRow = fRow - 1;
                    } else if (matrix[fRow][fCol].equals("F")) {
                        return fRow;
                    } else {
                        matrix[fRow][fCol] = "-";
                    }
                } else {
                    fRow = 0;
                    if (matrix[fRow][fCol].equals("B")) {
                        return fRow = fRow + 1;
                    } else if (matrix[fRow][fCol].equals("T")) {
                        return fRow = n - 1;
                    }
                    matrix[n - 1][fCol] = "-";
                    return fRow;
                }
                break;
            case "left":
                fCol = fCol - 1;
                matrix[fRow][fCol + 1] = "-";
                if (fCol >= 0) {
                    if (matrix[fRow][fCol].equals("B")) {
                        fCol = takeDirection(matrix, token, fRow, fCol, n);
                        if (fCol == 0) {
                            matrix[fRow][fCol] = "B";
                        } else {
                            if (fCol == n - 1) {
                                matrix[fRow][0] = "B";
                            } else {
                                matrix[fRow][fCol + 1] = "B";
                            }

                        }
                    } else if (matrix[fRow][fCol].equals("T")) {
                        return fCol = fCol + 1;
                    } else if (matrix[fRow][fCol].equals("F")) {
                        return fCol;
                    } else {
                        matrix[fRow][fCol] = "-";
                    }
                } else {
                    fCol = n - 1;
                    if (matrix[fRow][fCol].equals("B")) {
                        matrix[fRow][fCol] = "B";
                        fCol = n - 2;
                    } else if (matrix[fRow][fCol].equals("T")) {
                        fCol = 0;
                        return fCol;
                    }
                    matrix[fRow][0] = "-";
                    return fCol;
                }
                break;
            case "right":
                fCol = fCol + 1;
                matrix[fRow][fCol - 1] = "-";
                if (fCol < n) {
                    if (matrix[fRow][fCol].equals("B")) {
                        fCol = takeDirection(matrix, token, fRow, fCol, n);
                        if (fCol == 0) {
                            matrix[fRow][n - 1] = "B";
                        } else {
                            matrix[fRow][fCol - 1] = "B";
                        }

                    } else if (matrix[fRow][fCol].equals("T")) {

                        return fCol = fCol - 1;


                    } else if (matrix[fRow][fCol].equals("F")) {
                        return fCol;
                    } else {
                        matrix[fRow][fCol] = "-";
                    }
                } else {
                    fCol = 0;
                    if (matrix[fRow][fCol].equals("T")) {
                        return fCol = n - 1;
                    } else if (matrix[fRow][fCol].equals("B")) {
                        matrix[fRow][n - 1] = "-";
                        return fCol + 1;
                    } else if (matrix[fRow][fCol].equals("F")) {
                        matrix[fRow][n - 1] = "-";
                        return fCol;
                    }
                }
                break;
        }
        int result = 0;
        if (token.equals("right") || token.equals("left")) {
            result = fCol;
        } else {
            result = fRow;
        }
        return result;
    }
}


