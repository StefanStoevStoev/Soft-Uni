package L_2_Shapes;

public abstract class Shape {

    private Double perimeter;
    private Double area;

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setArea(Double area) {
        this.area = area;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public Double getArea() {
        return area;
    }

    protected abstract void calculatePerimeter();
    protected abstract void calculateArea();
}
