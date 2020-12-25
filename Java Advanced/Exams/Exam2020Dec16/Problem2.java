package Exam2020Dec16;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        String[][] matrix = new String[n][n];

        int oRow = 0;
        int oCol = 0;
        int o2Row = 0;
        int o2Col = 0;
        int sRow = 0;
        int sCol = 0;
        boolean flag = false;
        for (int k = 0; k < n; k++) {
            String[] array = scan.nextLine().split("");
            for (int col = 0; col < n; col++) {

                if (array[col].equals("S")) {
                    sRow = k;
                    sCol = col;
                } else if (array[col].equals("O") && !flag) {
                    oRow = k;
                    oCol = col;
                    flag = true;
                } else if (flag && array[col].equals("O")) {
                    o2Row = k;
                    o2Col = col;
                }
            }
            matrix[k] = array;
        }
        int collectMoney = 0;

        while (sRow >= 0 && sRow < n && sCol >= 0 && sCol < n) {
            String direction = scan.nextLine();


            switch (direction) {
                case "left":
                    sCol = sCol - 1;
                    matrix[sRow][sCol + 1] = "-";
                    if (sCol >= 0) {
                        if (!matrix[sRow][sCol].equals("O") && !matrix[sRow][sCol].equals("-")) {
                            int digit = Integer.parseInt(matrix[sRow][sCol]);
                            collectMoney += digit;
                        }
                        if (matrix[sRow][sCol].equals("O")) {
                            if (sRow == oRow && sCol == oCol) {
                                matrix[sRow][sCol] = "-";
                                matrix[o2Row][o2Col] = "S";
                                sRow = o2Row;
                                sCol = o2Col;
                            } else {
                                matrix[sRow][sCol] = "-";
                                matrix[oRow][oCol] = "S";
                                sRow = oRow;
                                sCol = oCol;
                            }
                        } else {
                            matrix[sRow][sCol] = "S";
                        }
                    } else {
                        voidSs(matrix, collectMoney);
                        return;
                    }
                    break;
                case "right":
                    sCol = sCol + 1;
                    matrix[sRow][sCol - 1] = "-";
                    if (sCol < n) {
                        if (!matrix[sRow][sCol].equals("O") && !matrix[sRow][sCol].equals("-")) {
                            int digit = Integer.parseInt(matrix[sRow][sCol]);
                            collectMoney += digit;
                        }
                        if (matrix[sRow][sCol].equals("O")) {
                            if (sRow == oRow && sCol == oCol) {
                                matrix[sRow][sCol] = "-";
                                matrix[o2Row][o2Col] = "S";
                                sRow = o2Row;
                                sCol = o2Col;
                            } else {
                                matrix[sRow][sCol] = "-";
                                matrix[oRow][oCol] = "S";
                                sRow = oRow;
                                sCol = oCol;
                            }
                        } else {
                            matrix[sRow][sCol] = "S";
                        }
                    } else {
                        voidSs(matrix, collectMoney);
                        return;
                    }
                    break;
                case "down":
                    sRow = sRow + 1;
                    matrix[sRow - 1][sCol] = "-";
                    if (sRow < n) {
                        if (!matrix[sRow][sCol].equals("O") && !matrix[sRow][sCol].equals("-")) {
                            int digit = Integer.parseInt(matrix[sRow][sCol]);
                            collectMoney += digit;
                        }
                        if (matrix[sRow][sCol].equals("O")) {
                            if (sRow == oRow && sCol == oCol) {
                                matrix[sRow][sCol] = "-";
                                matrix[o2Row][o2Col] = "S";
                                sRow = o2Row;
                                sCol = o2Col;
                            } else {
                                matrix[sRow][sCol] = "-";
                                matrix[oRow][oCol] = "S";
                                sRow = oRow;
                                sCol = oCol;
                            }
                        } else {
                            matrix[sRow][sCol] = "S";
                        }
                    } else {
                        voidSs(matrix, collectMoney);
                        return;
                    }
                    break;
                case "up":
                    sRow = sRow - 1;
                    matrix[sRow + 1][sCol] = "-";
                    if (sRow >= 0) {
                        if (!matrix[sRow][sCol].equals("O") && !matrix[sRow][sCol].equals("-")) {
                            int digit = Integer.parseInt(matrix[sRow][sCol]);
                            collectMoney += digit;
                        }
                        if (matrix[sRow][sCol].equals("O")) {
                            if (sRow == oRow && sCol == oCol) {
                                matrix[sRow][sCol] = "-";
                                matrix[o2Row][o2Col] = "S";
                                sRow = o2Row;
                                sCol = o2Col;
                            } else {
                                matrix[sRow][sCol] = "-";
                                matrix[oRow][oCol] = "S";
                                sRow = oRow;
                                sCol = oCol;
                            }
                        } else {
                            matrix[sRow][sCol] = "S";
                        }
                    } else {
                        voidSs(matrix, collectMoney);
                        return;
                    }
                    break;
            }
            if (collectMoney >= 50) {
                voidSs(matrix, collectMoney);
                return;
            }
        }
        voidSs(matrix, collectMoney);
    }

    private static void voidSs(String[][] matrix, int collectMoney) {
        if (collectMoney >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
            System.out.printf("Money: %d%n", collectMoney);
        } else {
            System.out.println("Bad news, you are out of the bakery.");
            System.out.printf("Money: %d%n", collectMoney);
        }
        for (String[] strings : matrix) {
            for (int k = 0; k < strings.length; k++) {
                System.out.print(strings[k]);
            }
            System.out.println();
        }
    }
}