import java.io.*;
import java.util.*;

public class Q11501 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            answer.append(getResult()).append("\n");
        }
        System.out.println(answer);
    }

    private static long getResult() throws IOException {
        long result = 0;

        /* Input */
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = Integer.parseInt(st.nextToken());
        }

        /* Solve */
        int maxPrice = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, days[i]);
            result += maxPrice - days[i];
        }

        return result;
    }
}