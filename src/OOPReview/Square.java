package OOPReview;

public class Square extends Rectangle {
    public Square(int sideLength) {
        super(sideLength, sideLength);
    }

    public String toString() {
        return "OOPReview.Square: sideLength = " + super.width;
    }
}
