import java.io.*;
import java.util.*;

public class Q11726 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static long[] DP;

    public static void main(String[] args) throws IOException {
        // input
        N = Integer.parseInt(br.readLine());
        DP = new long[N + 2];

        // solve
        DP[1] = 1;
        DP[2] = 2;
        for (int i = 3; i <= N; i++) {
            DP[i] = (DP[i - 1] + DP[i - 2]) % 10007;
        }

        // output
        System.out.println(DP[N]);
    }
}