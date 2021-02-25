package PointInRectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Point leftPoints = createPointFromTwoInts(scan);
        Point rightPoints = createPointFromTwoInts(scan);

        Rectangle rectangle = new Rectangle(leftPoints,rightPoints);

        int n = scan.nextInt();

        for (int k = 0; k < n; k++) {

            Point point = createPointFromTwoInts(scan);
            System.out.println(rectangle.contains(point));
        }

    }
    public static Point createPointFromTwoInts(Scanner scan){
        int pointX = scan.nextInt();
        int pointY = scan.nextInt();
        return new Point(pointX,pointY);
    }
}
