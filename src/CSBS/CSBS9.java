package CSBS;
import BinaryTrees.IntSearchTree;

public class CSBS9 {
    public static void main(String[] args) {
        IntSearchTree t1 = new IntSearchTree();
        t1.add(5);
        t1.add(3);
        t1.add(2);
        t1.add(1);
        t1.add(4);
        t1.add(6);
        t1.add(7);
        t1.add(9);
        t1.add(8);
        t1.printSideways();
        System.out.println(t1.countLeaves());
        System.out.println(t1.countLeftNodes());
        System.out.println(t1.height());
        t1.numberNodes();
        t1.printSideways();
        t1.print();
    }
}
