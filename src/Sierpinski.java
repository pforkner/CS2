/*
         C
        /\
       /  \
 M_AC /____\ M_BC
     /\    /\
    /  \  /  \
   /____\/____\
  A    M_AB    B

  */

import java.awt.*;

public class Sierpinski {
    public static Point midpoint(Point p1, Point p2) {
        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }

    public static void sierpinkski(Graphics g, int level, Point A, Point B, Point C) {
        if (level == 1) { // base case
            // just draw the triangle
            int[] xpoints = {A.x, B.x, C.x};
            int[] ypoints = {A.y, B.y, C.y};
            g.fillPolygon(xpoints, ypoints, 3);
        } else {
            Point M_AB = midpoint(A, B);
            Point M_BC = midpoint(B, C);
            Point M_AC = midpoint(A, C);
            // draw the lower left triangle
            sierpinkski(g, level - 1, A, M_AB, M_AC);
            // draw the lower right triangle
            sierpinkski(g, level - 1, M_AB, B, M_BC);
            // draw the top triangle
            sierpinkski(g, level - 1, M_AC, M_BC, C);
        }
    }

    public static void main(String[] args) {
        int width = 800, height = 800;
        DrawingPanel panel = new DrawingPanel(width, height);
        Graphics g = panel.getGraphics();
        int dotSize = 5;
        Point A = new Point(20, height - 20);
        Point B = new Point(width - 20, height - 20);
        Point C = new Point(width/2, 20);
        int[] xpoints = {A.x, B.x, C.x};
        int[] ypoints = {A.y, B.y, C.y};
        sierpinkski(g, 20, A, B, C);
    }
}
