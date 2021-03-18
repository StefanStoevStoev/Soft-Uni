package L_2_Shapes;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5D);
        Shape rectangle = new Rectangle(5D, 7D);

        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
    }
}
