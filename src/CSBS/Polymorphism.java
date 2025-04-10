/*
|     | Kurt          | Eddie                  | Jerry                 | Chris                  |
|-----+---------------+------------------------+-----------------------+------------------------|
| a() | Kurt 1/Kurt 3 | Kurt 1/Eddie 3         | Kurt 1/Jerry 3/Kurt 3 | Kurt 1/Chris 3         |
| b() | compiler      | Kurt 1/Eddie 3/Eddie 2 | compiler              | Chris 2/Jerry 3/Kurt 3 |
| c() | Kurt 3        | Eddie 3                | Jerry 3/Kurt 3        | Chris 3                |
|     |               |                        |                       |                        |
 */

package CSBS;


public class Polymorphism {
    public static void main(String[] args) {
        Kurt   var1 = new Jerry();
        Chris  var2 = new Chris();
        Kurt   var3 = new Eddie();
        Kurt   var4 = new Chris();
        Object var5 = new Jerry();

        var1.a();
        System.out.println();
        var1.c();
        System.out.println();
        var2.a();
        System.out.println();
        var2.b();
        System.out.println();
        var3.a();
        System.out.println();
        // compile var3.b();
        var4.a();
        System.out.println();
        // compile var5.a();
        // runtime ((Chris) var5).a();
        ((Jerry) var1).a();
        System.out.println();
        ((Jerry) var4).a();
        System.out.println();
        // runtime ((Chris) var3).b();
        ((Eddie) var3).b();
        System.out.println();
        ((Jerry) var4).c();
        System.out.println();
        ((Kurt) var5).c();
    }
}

class Eddie extends Kurt {
    public void b() {
        a();
        System.out.println("Eddie 2");
    }

    public void c() {
        System.out.println("Eddie 3");
    }
}

class Kurt {
    public void a() {
        System.out.println("Kurt 1");
        c();
    }

    public void c() {
        System.out.println("Kurt 3");
    }
}

class Chris extends Jerry {
    public void b() {
        System.out.println("Chris 2");
        super.c();
    }

    public void c() {
        System.out.println("Chris 3");
    }
}

class Jerry extends Kurt {
    public void c() {
        System.out.println("Jerry 3");
        super.c();
    }
}