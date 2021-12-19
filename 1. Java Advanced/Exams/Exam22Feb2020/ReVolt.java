package Exam22Feb2020;

import java.util.Arrays;
import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int numCommands = Integer.parseInt(scan.nextLine());

        String[][] matrix = new String[n][n];
        int fCol = 0;
        int fRow = 0;
        for (int k = 0; k < n; k++) {
            String[] input = scan.nextLine().split("");
            matrix[k] = input;
            for (int h = 0; h < input.length; h++) {
                if (input[h].equals("f")) {
                    fCol = k;
                    fRow = h;
                }
            }
        }
        boolean reachF = false;
        for (int d = 0; d < numCommands; d++) {
            String moveDirection = scan.nextLine();

            switch (moveDirection) {
                case "left":
                    takeNewMatrixLeft(matrix, fCol, fRow);
                    fRow--;
                    if (fRow == -1) {
                        fRow = n - 1;
                    } else {
                        String nextPos = matrix[fCol][fRow];
                        if (nextPos.equals("B")) {
                            fRow--;
                            if (fRow == -1) {
                                fRow = n - 1;
                            }
                        } else if (nextPos.equals("T")) {
                            fRow++;
                        } else if (nextPos.equals("F")) {
                            reachF = true;
                            matrix[fCol][fRow] = "f";
                            printMatrix(matrix, reachF);
                            return;
                        }
                    }
                    break;
                case "right":
                    takeNewMatrixRight(matrix, fCol, fRow);
                    fRow++;
                    if (fRow == n) {
                        fRow = 0;
                    } else {
                        String nextPos = matrix[fCol][fRow];
                        if (nextPos.equals("B")) {
                            fRow++;
                            if (fRow == n) {
                                fRow = 0;
                            }
                        } else if (nextPos.equals("T")) {
                            fRow--;
                        } else if (nextPos.equals("F")) {
                            reachF = true;
                            matrix[fCol][fRow] = "f";
                            printMatrix(matrix, reachF);
                            return;
                        }
                    }
                    break;
                case "up":
                    takeNewMatrixUp(matrix, fCol, fRow, n);
                    fCol--;
                    if (fCol == -1) {
                        fCol = n - 1;
                    } else {
                        String nextPos = matrix[fCol][fRow];
                        if (nextPos.equals("B")) {
                            fCol--;
                            if (fCol == -1) {
                                fCol = n - 1;
                            }
                        } else if (nextPos.equals("T")) {
                            fCol++;
                        } else if (nextPos.equals("F")) {
                            reachF = true;
                            matrix[fCol][fRow] = "f";
                            printMatrix(matrix, reachF);
                            return;
                        }
                    }
                    break;
                case "down":

                    takeNewMatrixDown(matrix, fCol, fRow, n);
                    fCol++;
                    if (fCol == n) {
                        fCol = 0;
                    } else {
                        String nextPos = matrix[fCol][fRow];
                        if (nextPos.equals("B")) {
                            fCol++;
                            if (fCol == n) {
                                fCol = 0;
                            }
                        } else if (nextPos.equals("T")) {
                            fCol--;
                        } else if (nextPos.equals("F")) {
                            reachF = true;
                            matrix[fCol][fRow] = "f";
                            printMatrix(matrix, reachF);
                            return;
                        }
                    }
                    break;
            }

        }
        printMatrix(matrix, reachF);
    }

    private static void printMatrix(String[][] matrix, boolean reachF) {
        if (reachF) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        for (String[] strings : matrix) {
            System.out.println(Arrays.toString(strings).replaceAll("[\\[\\], ]", ""));
        }
    }

    private static String[][] takeNewMatrixDown(String[][] matrix, int fCol, int fRow, int n) {
        fCol++;

        if (fCol < n) {

            String nextElement = matrix[fCol][fRow];

            if (nextElement.equals("T")) {
                fCol--;
                matrix[fCol][fRow] = "f";
                matrix[fCol + 1][fRow] = "-";

            } else if (nextElement.equals("B")) {
                fCol++;

                if (fCol < matrix[fCol].length - 1) {
                    nextElement = matrix[fCol][fRow];
                    if (nextElement.equals("T")) {
                        fCol--;
                        matrix[fCol][fRow] = "f";
                        matrix[fCol + 1][fRow] = "-";
                    } else {
                        matrix[fCol][fRow] = "f";
                        matrix[fCol - 2][fRow] = "-";
                    }
                } else {
                    fCol = 0;
                    matrix[fCol][fRow] = "f";
                    matrix[matrix[fCol].length][fRow] = "-";
                }

            } else if (nextElement.equals("F")) {

                matrix[fCol - 1][fRow] = "-";
                return matrix;
            } else {
                matrix[fCol][fRow] = "f";
                matrix[fCol - 1][fRow] = "-";
            }
        } else {
            fCol = 0;
            matrix[fCol][fRow] = "f";
            matrix[matrix[fCol].length - 1][fRow] = "-";
        }
        return matrix;
    }

    private static String[][] takeNewMatrixUp(String[][] matrix, int fCol, int fRow, int n) {
        fCol--;

        if (fCol >= 0) {
            String nextElement = matrix[fCol][fRow];
            if (nextElement.equals("T")) {
                fCol++;
                matrix[fCol][fRow] = "f";
                matrix[fCol - 1][fRow] = "-";

            } else if (nextElement.equals("B")) {
                fCol--;

                if (fCol >= 0) {
                    nextElement = matrix[fCol][fRow];
                    if (nextElement.equals("T")) {
                        fCol++;
                        matrix[fCol][fRow] = "f";
                        matrix[fCol - 1][fRow] = "-";
                    } else {
                        matrix[fCol][fRow] = "f";
                        matrix[fCol][fRow] = "-";
                    }
                } else {
                    fCol = matrix[fCol].length - 1;
                    matrix[fCol][fRow] = "f";
                    matrix[0][fRow] = "-";
                }


            } else if (nextElement.equals("F")) {

                matrix[fCol - 1][fRow] = "-";
                return matrix;

            } else {
                matrix[fCol][fRow] = "f";
                matrix[fCol + 1][fRow] = "-";
            }
        } else {
            fCol = n - 1;
            matrix[fCol][fRow] = "f";
            matrix[0][fRow] = "-";
        }
        return matrix;
    }


    private static String[][] takeNewMatrixRight(String[][] matrix, int fCol, int fRow) {

        fRow++;

        if (fRow < matrix[fCol].length - 1) {
            String nextElement = matrix[fCol][fRow];
            if (nextElement.equals("T")) {
                fRow--;
                matrix[fCol][fRow] = "f";

            } else if (nextElement.equals("B")) {
                fRow++;

                if (fRow < matrix[fCol].length - 1) {
                    nextElement = matrix[fCol][fRow];
                    if (nextElement.equals("T")) {
                        fRow--;
                        matrix[fCol][fRow] = "f";
                        matrix[fCol][fRow + 1] = "T";
                    } else {
                        matrix[fCol][fRow] = "f";
                        matrix[fCol][fRow - 1] = "-";
                    }
                } else {
                    fRow = 0;
                    int n = matrix[fCol].length - 1;
                    matrix[fCol][fRow] = "f";
                    matrix[fCol][n] = "-";
                }

            } else if (nextElement.equals("F")) {

                matrix[fCol][fRow - 1] = "-";
                return matrix;
            } else {
                matrix[fCol][fRow] = "f";
                matrix[fCol][fRow + 1] = "-";
            }
        } else {
            fRow = 0;
            int n = matrix[fCol].length - 1;
            matrix[fCol][fRow] = "f";
            matrix[fCol][n] = "-";
        }
        return matrix;
    }

    private static String[][] takeNewMatrixLeft(String[][] matrix, int fCol, int fRow) {
        fRow--;

        if (fRow >= 0) {
            String nextElement = matrix[fCol][fRow];
            if (nextElement.equals("T")) {
                fRow++;
                matrix[fCol][fRow] = "f";
                matrix[fCol][fRow - 1] = "-";

            } else if (nextElement.equals("B")) {
                fRow--;

                if (fRow >= 0) {
                    nextElement = matrix[fCol][fRow];
                    if (nextElement.equals("T")) {
                        fRow++;
                        matrix[fCol][fRow] = "f";
                        matrix[fCol][fRow - 1] = "-";
                    } else {
                        matrix[fCol][fRow] = "f";
                        matrix[fCol][fRow - 1] = "-";
                    }
                } else {
                    fRow = matrix[fRow].length - 1;
                    matrix[fCol][fRow] = "f";
                    matrix[fCol][0] = "-";
                }


            } else if (nextElement.equals("F")) {

                matrix[fCol][fRow - 1] = "-";
                return matrix;

            } else {
                matrix[fCol][fRow] = "f";
                matrix[fCol][fRow + 1] = "-";
            }
        } else {
            fRow = matrix[fRow].length - 1;
            matrix[fCol][fRow] = "f";
            matrix[fCol][0] = "-";
        }
        return matrix;
    }
}
