package E_ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public double calculateSurfaceArea() {
        return calculateLateralSurfaceArea() + 2 * this.length * this.width;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * this.height * this.length + 2 * this.height * this.width;
    }

    public double calculateVolume() {
        return this.height * this.length * this.width;
    }

    private void setLength(double length) {////////////
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {///////////
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%n" +
                "Lateral Surface Area - %.2f%n" +
                "Volume – %.2f%n", calculateSurfaceArea(), calculateLateralSurfaceArea(), calculateVolume());
    }
}
