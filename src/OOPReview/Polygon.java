package OOPReview;

public class Polygon extends Object {
    private int sides;

    public int getSides() {
        return sides;
    }

    public Polygon(int sides) {
        this.sides = sides;
    }

    @Override
    public String toString() {
        return "OOPReview.Polygon [sides=" + sides + "]";
    }

}
