package Recursion;
// This program solves the classic "8 queens" problem using recursive
// backtracking.  The Board class does most of the work of keeping track of the
// chessboard state.

public class Queens {
    public static void main(String[] args) {
        giveIntro();
//        Scanner console = new Scanner(System.in);
//        System.out.print("What size board do you want to use? ");
//        int size = console.nextInt();
//        System.out.println();
        for (int size = 11; size <= 121; size += 11) {
            long startTime = System.currentTimeMillis();
            Board b = new Board(size);
            solve(b);
            long endTime = System.currentTimeMillis();
            System.out.println("Total execution time: " + (endTime - startTime) + "ms");
        }
    }

    // post: explains program to user
    public static void giveIntro() {
        System.out.println("This program solves the classic '8 queens'");
        System.out.println("problem, placing queens on a chessboard so");
        System.out.println("that no two queens threaten each other.");
        System.out.println();
    }

    // pre : queens have been safely placed in columns 1 through (col - 1)
    // post: recursively searchs the board for a solution starting at col,
    //       returning true iff such a solution occurs and storing the
    //       solution in board if it exists
    private static boolean explore(Board b, int col) {
        if (col > b.size())
            return true;
        else {
            for (int row = 1; row <= b.size(); row++)
                if (b.safe(row, col)) {
                    b.place(row, col);
                    if (explore(b, col + 1))
                        return true;
                    b.remove(row, col);
                }
            return false;
        }
    }
          
    // post: searches for a solution to the 8 queens problem with this
    //       board, reporting result.
    public static void solve(Board solution) {
        if (!explore(solution, 1))
            System.out.println("No solution.");
        else {
            System.out.println("One solution is as follows:");
            solution.print();
        }
    }
}
