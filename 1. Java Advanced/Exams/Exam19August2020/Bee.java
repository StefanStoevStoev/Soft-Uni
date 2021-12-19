package Exam19August2020.Bee;

import java.util.Arrays;
import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[n][n];
        int bRow = 0;
        int bColumn = 0;

        for (int k = 0; k < n; k++) {
            String[] input = scan.nextLine().split("");
            for (int h = 0; h < input.length; h++) {
                ;
                if (input[h].equals("B")) {
                    bRow = h;
                    bColumn = k;
                }
            }
            matrix[k] = input;
        }

        String input = scan.nextLine();
        int pollinate = 0;

        while (!"End".equals(input)) {

            if (input.equals("right")) {
                if (bRow + 1 < n) {
                    String signOfNewPosition = matrix[bColumn][bRow + 1];
                    if (signOfNewPosition.equals(".")) {
                        matrix[bColumn][bRow] = ".";
                        bRow += 1;
                        matrix[bColumn][bRow] = "B";
                    } else if (signOfNewPosition.equals("f")) {
                        matrix[bColumn][bRow] = ".";
                        bRow += 1;
                        matrix[bColumn][bRow] = "B";
                        pollinate += 1;
                    } else if (signOfNewPosition.equals("O")) {
                        matrix[bColumn][bRow] = ".";
                        bRow += 1;
                        matrix[bColumn][bRow] = "B";
                        if (bRow + 1 < n) {
                            signOfNewPosition = matrix[bColumn][bRow + 1];
                            if (signOfNewPosition.equals(".")) {
                                matrix[bColumn][bRow] = ".";
                                bRow += 1;
                                matrix[bColumn][bRow] = "B";
                            } else if (signOfNewPosition.equals("f")) {
                                matrix[bColumn][bRow] = ".";
                                bRow += 1;
                                matrix[bColumn][bRow] = "B";
                                pollinate += 1;
                            }
                        } else {
                            matrix[bColumn][bRow] = ".";
                            System.out.println("The bee got lost!");
                            printMatrix(matrix, pollinate);
                            return;
                        }
                    }
                } else {
                    matrix[bColumn][bRow] = ".";
                    System.out.println("The bee got lost!");
                    printMatrix(matrix, pollinate);
                    return;
                }

            } else if (input.equals("left")) {////////
                if (bRow - 1 >= 0) {
                    String signOfNewPosition = matrix[bColumn][bRow - 1];
                    if (signOfNewPosition.equals(".")) {
                        matrix[bColumn][bRow] = ".";
                        bRow -= 1;
                        matrix[bColumn][bRow] = "B";
                    } else if (signOfNewPosition.equals("f")) {
                        matrix[bColumn][bRow] = ".";
                        bRow -= 1;
                        matrix[bColumn][bRow] = "B";
                        pollinate += 1;
                    } else if (signOfNewPosition.equals("O")) {
                        matrix[bColumn][bRow] = ".";
                        bRow -= 1;
                        matrix[bColumn][bRow] = "B";
                        if (bRow - 1 >= 0) {
                            signOfNewPosition = matrix[bColumn][bRow - 1];
                            if (signOfNewPosition.equals(".")) {
                                matrix[bColumn][bRow] = ".";
                                bRow -= 1;
                                matrix[bColumn][bRow] = "B";
                            } else if (signOfNewPosition.equals("f")) {
                                matrix[bColumn][bRow] = ".";
                                bRow -= 1;
                                matrix[bColumn][bRow] = "B";
                                pollinate += 1;
                            }
                        } else {
                            matrix[bColumn][bRow] = ".";
                            System.out.println("The bee got lost!");
                            printMatrix(matrix, pollinate);
                            return;
                        }
                    }
                } else {
                    matrix[bColumn][bRow] = ".";
                    System.out.println("The bee got lost!");
                    printMatrix(matrix, pollinate);
                    return;
                }

            } else if (input.equals("down")) {
                if (bColumn + 1 < n) {
                    String signOfNewPosition = matrix[bColumn + 1][bRow];
                    if (signOfNewPosition.equals(".")) {
                        matrix[bColumn][bRow] = ".";
                        bColumn += 1;
                        matrix[bColumn][bRow] = "B";
                    } else if (signOfNewPosition.equals("f")) {
                        matrix[bColumn][bRow] = ".";
                        bColumn += 1;
                        matrix[bColumn][bRow] = "B";
                        pollinate += 1;
                    } else if (signOfNewPosition.equals("O")) {
                        matrix[bColumn][bRow] = ".";
                        bColumn += 1;
                        matrix[bColumn][bRow] = "B";
                        if (bColumn + 1 < n) {
                            signOfNewPosition = matrix[bColumn + 1][bRow];
                            if (signOfNewPosition.equals(".")) {
                                matrix[bColumn][bRow] = ".";
                                bColumn += 1;
                                matrix[bColumn][bRow] = "B";
                            } else if (signOfNewPosition.equals("f")) {
                                matrix[bColumn][bRow] = ".";
                                bColumn += 1;
                                matrix[bColumn][bRow] = "B";
                                pollinate += 1;
                            }
                        } else {
                            matrix[bColumn][bRow] = ".";
                            System.out.println("The bee got lost!");
                            printMatrix(matrix, pollinate);
                            return;
                        }
                    }

                } else {
                    matrix[bColumn][bRow] = ".";
                    System.out.println("The bee got lost!");
                    printMatrix(matrix, pollinate);
                    return;
                }

            } else if (input.equals("up")) {
                if (bColumn - 1 >= 0) {
                    String signOfNewPosition = matrix[bColumn - 1][bRow];
                    if (signOfNewPosition.equals(".")) {
                        matrix[bColumn][bRow] = ".";
                        bColumn -= 1;
                        matrix[bColumn][bRow] = "B";
                    } else if (signOfNewPosition.equals("f")) {
                        matrix[bColumn][bRow] = ".";
                        bColumn -= 1;
                        matrix[bColumn][bRow] = "B";
                        pollinate += 1;
                    } else if (signOfNewPosition.equals("O")) {
                        matrix[bColumn][bRow] = ".";
                        bColumn -= 1;
                        matrix[bColumn][bRow] = "B";
                        if (bColumn - 1 >= 0) {
                            signOfNewPosition = matrix[bColumn - 1][bRow];
                            if (signOfNewPosition.equals(".")) {
                                matrix[bColumn][bRow] = ".";
                                bColumn -= 1;
                                matrix[bColumn][bRow] = "B";
                            } else if (signOfNewPosition.equals("f")) {
                                matrix[bColumn][bRow] = ".";
                                bColumn -= 1;
                                matrix[bColumn][bRow] = "B";
                                pollinate += 1;
                            }
                        } else {
                            matrix[bColumn][bRow] = ".";
                            System.out.println("The bee got lost!");
                            printMatrix(matrix, pollinate);
                            return;
                        }
                    }

                } else {
                    matrix[bColumn][bRow] = ".";
                    System.out.println("The bee got lost!");
                    printMatrix(matrix, pollinate);
                    return;
                }
            }

            input = scan.nextLine();
        }
        printMatrix(matrix, pollinate);
    }

    private static void printMatrix(String[][] matrix, int pollinate) {

        if (pollinate >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinate);
        } else {
            int neededFlowers = 5 - pollinate;
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", neededFlowers);
        }
        for (String[] strings : matrix) {
            System.out.println(Arrays.toString(strings).replaceAll("[\\[, \\]\"]", ""));
        }
    }

}
