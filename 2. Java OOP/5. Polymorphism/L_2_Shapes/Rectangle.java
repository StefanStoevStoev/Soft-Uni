package L_2_Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);
        this.calculatePerimeter();
        this.calculateArea();
    }

    public Double getHeight() {
        return height;
    }

    public Double getWidth() {
        return width;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2 * this.height + 2 * this.width);
    }

    @Override
    protected void calculateArea() {
        setArea(this.height * this.width);
    }
}
