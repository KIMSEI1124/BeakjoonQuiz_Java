import java.io.*;
import java.util.*;

public class Q9095 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static int T;
    static int N;

    public static void main(String[] args) throws IOException {
        // input
        T = Integer.parseInt(br.readLine());
        int[][] DP = new int[11][3];
        DP[1][0] = 1;
        DP[2][0] = 1;
        DP[3][0] = 1;
        DP[3][1] = 1;

        // solve
        for (int i = 1; i < 11; i++) {

        }
        while (T > 0) {
            N = Integer.parseInt(br.readLine());
            T--;
        }
        // output
        System.out.println(ans);
    }
}