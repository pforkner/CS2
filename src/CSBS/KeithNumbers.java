package CSBS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class KeithNumbers {

    public static List<Integer> int2List(int n) {
        List<Integer> result = new ArrayList<>();
        if (n == 0) result.add(0);
        while (n != 0) {
//            System.out.println(n/10 + "; " + n%10);
            result.add(n%10);
            n /= 10;
        }
        Collections.reverse(result);
        return result;
    }

    public static boolean isKeithNumber(int n) {
        // parse n into a list
        List<Integer> sequence = int2List(n);
        int numOfDigits = sequence.size();

        // add the next term to the list up to n
        // 7385
        while (sequence.get(sequence.size() - 1) < n) {
            int nextNum = 0;
            for (int i = 0; i < numOfDigits; i++) {
                nextNum += sequence.get(sequence.size() - 1 - i);
            }
            sequence.add(nextNum);
        }
        System.out.println(sequence);

        // if the last number in the sequence is equal to the number itself
        //  then its a Keith number
        return sequence.get(sequence.size() - 1) == n;
    }

    public static void main(String[] args) {
//        List<Integer> aList = int2List(7385);
//        System.out.println(aList);
        System.out.println(isKeithNumber(7385));
    }
}
