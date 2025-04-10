public class ArrayIntListClient {
    public static void main(String[] args) {
        ArrayIntList a1 = new ArrayIntList();
        System.out.println(a1);
        a1.add(3);
        a1.add(1);
        a1.add(4);
        a1.add(1);
        a1.add(5);
        a1.add(9);
        System.out.println(a1);
        a1.remove(5);
        System.out.println(a1);
        a1.remove(2);
        System.out.println(a1);
        a1.remove(0);
        System.out.println(a1);

    }
}
