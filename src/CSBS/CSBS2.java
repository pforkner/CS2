package CSBS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSBS2 {

    public static void main(String[] args) {
        int[] v1 = {28, 1, 17, 4, 41, 9, 59, 8, 31, 30, 25};
        List<Integer> list = new ArrayList<>();
        for (int i : v1) list.add(i);
        System.out.println(list);

        List<Integer> v2 = new ArrayList<>(List.of(18, 7, 4, 24, 11));
        System.out.println(v2);

        List<Integer> v3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(v3);


    }
}
