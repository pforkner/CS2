package LinkedLists;

public class LinkedIntListPairProgramming {
    public static void main(String[] args) {
        int[] a1 = {1, 3, 5};
        LinkedIntList list1 = new LinkedIntList();
        for (int i : a1) {
            list1.add(i);
        }
        int[] a2 = {0, 2, 4, 6};
        LinkedIntList list2 = new LinkedIntList();
        for (int i : a2) {
            list2.add(i);
        }

        System.out.println(list1);
        System.out.println(list2);
        list1.mergeFrom(list2);
        System.out.println(list1);
        System.out.println(list2);

    }
}
