public class PolygonClient {
    public static void main(String[] args) {
        Polygon p1 = new Polygon(4);
//        System.out.println(p1);
        Rectangle r1 = new Rectangle(10, 5);
//        System.out.println(r1);
        Square s1 = new Square(3);
//        System.out.println(s1);
        Triangle t1 = new Triangle(3, 4, 5);
//        System.out.println(t1);
        Polygon p2 = new Rectangle(4, 5);

        Polygon[] polys = new Polygon[5];
        polys[0] = p1;
        polys[1] = r1;
        polys[2] = s1;
        polys[3] = t1;
        polys[4] = p2;

        for (Polygon p : polys) { // java for each loop
            System.out.println(p);
        }

//        System.out.println(((Triangle)p2).getArea());
        System.out.println(((Polygon)t1).toString());

        double x = 3.24;
        System.out.println((int)x); // type casting

    }
}
