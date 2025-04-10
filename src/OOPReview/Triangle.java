package OOPReview;

public class Triangle extends Polygon{
    double a;
    double b;
    double c;

    public double getArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        // https://en.wikipedia.org/wiki/Triangle#Area
    }

    public String toString() {
        return "OOPReview.Triangle: " + a + " " + b + " " + c;
    }

    public Triangle(double a, double b, double c) {
        super(3);
        this.a = a;
        this.b = b;
        this.c = c;
    }


}
