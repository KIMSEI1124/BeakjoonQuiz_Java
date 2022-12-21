import java.io.*;
import java.util.Arrays;

public class Q2231 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int start = Math.max(1, N - (String.valueOf(N).length() * 9));
        for (int i = start; i < N; i++) {
            int sum = i + Arrays.stream(String.valueOf(i).split(""))
                    .mapToInt(Integer::parseInt)
                    .sum();
            if (N == sum) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}