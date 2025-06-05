package CSBS;

import LinkedLists.LinkedIntList;

public class CSBS8 {
    public static void main(String[] args) {
        int[] a = {3, 3, 9, 4, 2, 3, 8, 17, 4, 3, 18, 3};
        LinkedIntList list = new LinkedIntList();
        for (int i : a) {
            list.add(i);
        }
        System.out.println(list);
        list.removeAll(3);
        System.out.println(list);

        LinkedIntList list2 = new LinkedIntList();
        list2.removeAll(3);

        list.switchPairs();
        System.out.println(list);

        int[] a2 = {8, 8, 3, 7, 2, 2, 2, 4, -1, -1, 9, 9, 9, 9, 9};
        LinkedIntList list3 = new LinkedIntList();
        for (int i : a2) {
            list3.add(i);
        }
        list3.removeDuplicates();
        System.out.println(list3);

    }
}
