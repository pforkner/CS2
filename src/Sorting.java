import java.util.Arrays;

public class Sorting {
    public static void bubbleSort(int[] a) {
        // [2, 7, 1, 8, 2, 8]
        for (int i = a.length - 1; i > 0; i--) {
            int count = 0; // count how many times no swapping occurs
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) { // swap
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                } else count++;
            }
            if (count == i) break; // if no swapping occurred, break out the loop
        }
    }

    public static void mergeSort(int[] a) {
        // [6, 2, 4, 3, 5, 1]
        // [6, 2, 4] [3, 5, 1]
        // [6] [2, 4] [3] [5, 1]
        //     [2] [4]    [5] [1]
        //      [2, 4]     [1, 5]
        // [2, 4, 6] [1, 3, 5]
        // [1, 2, 3, 4, 5, 6]

        if (a.length > 1) {
            // split in the left and right halves
            int[] left = new int[a.length/2];
            int[] right = new int[a.length - left.length];
            for (int i = 0; i < left.length; i++) {
                left[i] = a[i];
            }
            for (int i = left.length; i < a.length; i++) {
                right[i - left.length] = a[i];
            }

            // recursively sort left and right halves
            mergeSort(left);
            mergeSort(right);

            // merge the halves
            merge(a, left, right);
        }

    }

    public static void merge(int[] result, int[] left, int[] right) {
        int i1 = 0; // left index
        int i2 = 0; // right index
        for (int i = 0; i < result.length; i++) {
            // pull from left
            if (i2 >= right.length || left[i1] < right[i2]) {
                result[i] = left[i1];
                i1++;
            } else { // otherwise pull from the right
                result[i] = right[i2];
                i2++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a1 = { 5, 4, 3, 2, 1 };
        int[] a2 = {};
//        bubbleSort(a2);
        mergeSort(a1);
        System.out.println(Arrays.toString(a1));
    }
}
