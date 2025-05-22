public class LinkedIntListTester {
    public static void main(String[] args) {
        LinkedIntList list = new LinkedIntList();
        System.out.println(list.front);
        list.add(3);
        System.out.println(list);
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(5);
        System.out.println(list);
        list.add(2, 7);
        System.out.println(list);
        list.add(0, 9);
        System.out.println(list);
        list.remove(5);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
    }
}
