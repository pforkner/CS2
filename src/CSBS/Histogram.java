package CSBS;

import java.util.*;

public class Histogram {
    public static void writeStars(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print('*');
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(73, 58, 73, 93, 82, 62, 80, 53, 93, 52, 92, 75, 65, 95, 23, 100, 75, 38, 80, 77, 92, 60, 98, 95, 62, 87, 97, 73, 78, 72, 55, 58, 42, 31, 78, 70, 78, 74, 70, 60, 72, 75, 84, 87, 62, 17, 92, 78, 74, 65, 90));
        Map<Character, Integer> bins = new TreeMap<>();
        bins.put('A', 0);
        bins.put('B', 0);
        bins.put('C', 0);
        bins.put('D', 0);
        bins.put('F', 0);

        for (int i : list) {
            if (i >= 90) bins.put('A', bins.get('A') + 1);
            else if (i >= 80) bins.put('B', bins.get('B') + 1);
            else if (i >= 70) bins.put('C', bins.get('C') + 1);
            else if (i >= 60) bins.put('D', bins.get('D') + 1);
            else bins.put('F', bins.get('F') + 1);
        }

        System.out.print("A: "); writeStars(bins.get('A')); System.out.println();
        System.out.print("B: "); writeStars(bins.get('B')); System.out.println();
        System.out.print("C: "); writeStars(bins.get('C')); System.out.println();
        System.out.print("D: "); writeStars(bins.get('D')); System.out.println();
        System.out.print("F: "); writeStars(bins.get('F')); System.out.println();
    }
}
