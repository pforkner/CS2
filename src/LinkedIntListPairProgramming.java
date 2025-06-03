public class LinkedIntListPairProgramming {
    public static void main(String[] args) {
        int[] a1 = {-3, 0, 9, 12, 43, 54};
        LinkedIntList list1 = new LinkedIntList();
        for (int i : a1) {
            list1.add(i);
        }
        int[] a2 = {9, 9, 15, 98};
        LinkedIntList list2 = new LinkedIntList();
        for (int i : a2) {
            list2.add(i);
        }

        System.out.println(list1);
        System.out.println(list2);
//        list1.mergeFrom(list2);
        System.out.println(list1);
        System.out.println(list2);

    }
}
