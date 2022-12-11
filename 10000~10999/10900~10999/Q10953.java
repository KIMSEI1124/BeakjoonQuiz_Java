import java.io.*;
import java.util.*;

public class Q10953 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int sum = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).sum();
            answer.append(sum).append("\n");
        }
        System.out.println(answer);
    }
}