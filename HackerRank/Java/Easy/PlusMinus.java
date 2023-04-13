import java.util.*;

public class PlusMinus {
    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int[] result = { 0, 0, 0 }; // pos, neg, zero
        StringBuilder answer = new StringBuilder();
        for (Integer number : arr) {
            if (number > 0) {
                result[0]++;
            } else if (number < 0) {
                result[1]++;
            } else {
                result[2]++;
            }
        }
        for (int i : result) {
            double ratio = i / arr.size();
            System.out.println(i);
            answer.append(String.format("%.6f", ratio) + "\n");
        }
        System.out.println(answer);
    }
}
