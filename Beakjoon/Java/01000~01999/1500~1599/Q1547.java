import java.io.*;
import java.util.Arrays;

public class Q1547 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int m = Integer.parseInt(br.readLine());
        int target = 1;

        while (m-- > 0) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (input[0] == target) {
                target = input[1];
            } else if (input[1] == target) {
                target = input[0];
            }
        }

        System.out.println(target);
    }
}