public class PlayingWithRecursion {
    public static void myRecursiveMethod(int n) {
        if (n >= 0) {
            System.out.print(n + ", ");
            myRecursiveMethod(n - 1);
            System.out.print(n + ", ");
        }
    }

    // 2^5 = 2 * 2^4 = 2 * 2 * 2^3 = ... = 2 * 2 * 2 * 2 * 2^1
    // returns a^b
    public static int pow(int a, int b) {
        if (b == 1) return a; // base case
        return a * pow(a, b - 1); // recursive case (leap of faith)
    }

    // n! = n*(n - 1)*(n - 2)*...*3*2*1
    // 5! = 5*4!
    public static int factorial(int n) {
        if (n == 0) return 1;           // base case
        return factorial(n - 1) * n;    // recursive case
    }

    // Tacocat, Racecar, noon
    public static boolean isPalindrome(String s) {
//        if (s.length() <= 1) return true;
//        return s.toLowerCase().charAt(0) == s.toLowerCase().charAt(s.length() - 1)
//                && isPalindrome(s.substring(1, s.length() - 1));
        return isPalindromeHelper(s.toLowerCase());
    }

    private static boolean isPalindromeHelper(String s) {
        if (s.length() <= 1) return true;
        return s.charAt(0) == s.charAt(s.length() - 1)
                && isPalindrome(s.substring(1, s.length() - 1));
    }

    public static void hanoi(int n, int start, int end) {
        if (n == 1) System.out.println("move disk 1 from peg " + start + " to peg " + end);
        else {
//            int other = 1;
//            if (start == 1 && end == 2 || start == 2 && end == 1) { other = 3; }
//            if (start == 1 && end == 3 || start == 3 && end == 1) { other = 2; }
            // start + end + other = 6
            int other = 6 - start - end;

            // move the smaller tower to the other peg
            hanoi(n - 1, start, other);
            // print the current move
            System.out.println("move disk " + n + " from peg " + start + " to peg " + end);
            // move the smaller tower from the other peg to this peg
            hanoi(n - 1, other, end);
        }
    }

    // return nth fibonacci number
    // 0 1 2 3 4 5 6
    // 0 1 1 2 3 5 8
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
//        myRecursiveMethod(3);
//        int answer = pow(2, 4);
//        System.out.println(answer);
//        System.out.println(factorial(3));
//        System.out.println(factorial(5));
//        System.out.println(isPalindrome("tacocaT"));
//        hanoi(3, 1, 3);
        System.out.println(fibonacci(100));
    }
}
