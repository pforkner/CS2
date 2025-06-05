package LinkedLists;

public class LinkedIntListTester {
    public static void main(String[] args) {
        LinkedIntList list1 = new LinkedIntList();
        list1.add(3);
        list1.add(1);
        list1.add(4);
        list1.add(1);
        list1.add(5);
        System.out.println(list1);
        LinkedIntList list2 = new LinkedIntList();
        list2.add(3);
        list2.add(1);
        list2.add(4);
        list2.add(1);
        list2.add(5);
        System.out.println(list2);
        System.out.println(list1.equals2(list2));




    }
}
