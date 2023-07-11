import java.io.*;
import java.util.*;

public class Q4101 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while (true) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (isEnd(input)) {
                break;
            }
            if (input[0] > input[1]) {
                answer.append("Yes");
            } else {
                answer.append("No");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }

    private static boolean isEnd(int[] data) {
        if (data[0] == 0 && data[1] == 0) {
            return true;
        }
        return false;
    }
}