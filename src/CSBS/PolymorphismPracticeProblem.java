package CSBS;

public class PolymorphismPracticeProblem {
    public static void main(String[] args) {
        Alpha v1 = new Beta();
        Alpha v2 = new Gamma();
        Beta v3 = new Gamma();
        Object v4 = new Delta();

        v1.methodA();
        System.out.println();
        v1.methodB();
        System.out.println();
        // v1.methodC();
        System.out.println("compiler error\n");
        v2.methodA();
        System.out.println();
        v2.methodB();
        System.out.println();
        v3.methodA();
        System.out.println();
        v3.methodB();
        System.out.println();
        // v4.methodA();
        System.out.println("compiler error\n");
        ((Gamma)v2).methodC();
        System.out.println();
        ((Beta)v1).methodB();
        System.out.println();
        ((Delta)v4).methodC();
        System.out.println();
        // ((Gamma)v1).methodC();
        System.out.println("rumtime error\n");

    }
}

class Alpha {
    public void methodA() {
        System.out.println("Alpha A");
    }

    public void methodB() {
        System.out.println("Alpha B");
    }
}

class Delta extends Alpha {
    public void methodC() {
        System.out.println("Delta C");
    }
}

class Beta extends Alpha {
    public void methodA() {
        System.out.println("Beta A");
        super.methodA();
    }
}

class Gamma extends Beta {
    public void methodB() {
        System.out.println("Gamma B");
        super.methodB();
    }

    public void methodC() {
        System.out.println("Gamma C");
    }
}
