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
        return "Polygon [sides=" + sides + "]";
    }

}
