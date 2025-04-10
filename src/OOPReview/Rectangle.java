package OOPReview;

public class Rectangle extends Polygon {
    double width;
    double height;

    @Override
    public String toString() {
        return "OOPReview.Rectangle: width = " + width + " height = " + height;
    }

    public double getArea() {
        return width * height;
    }

    public Rectangle(double width, double height) {
        super(4); // rectangle has four sides
        this.width = width;
        this.height = height;
    }
}
