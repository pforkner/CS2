public class PlayingWithComplexity {

    public static void main(String[] args) {
        int N = 2*100;
        long startTime = System.nanoTime();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    System.out.print("(" + i + "," + j + "," + k + ") ");
                }
            }
            System.out.println();
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("elapsedTime: " + elapsedTime);
    }
}
