package ArrayLists;

import java.util.ArrayList;

public class BoxingUnboxing {
    public static void main(String... args) {
        int n = 127;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(n);
        list.add(n);
        // only true for -128 < =n <= 127
        System.out.println(list.get(0) == list.get(1));
        // true for all n???
        System.out.println(list.get(0).equals(list.get(1)));
    }
}
