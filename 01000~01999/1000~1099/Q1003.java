import java.io.*;
import java.util.*;

public class Q1003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static int T, N;
    static int[][] DP;

    public static void main(String[] args) throws IOException {
        // input
        T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
        DP = new int[2][41];
        DP[0][0] = 1;
        DP[1][1] = 1;

        // solve
        /* 1. 피보나치 함수 DP 구하기 */
        for (int i = 2; i <= 40; i++) {
            DP[0][i] = DP[0][i - 1] + DP[0][i - 2];
            DP[1][i] = DP[1][i - 1] + DP[1][i - 2];
        }

        /* 정답 입력 */
        while (T > 0) {
            N = Integer.parseInt(br.readLine());
            ans.append(DP[0][N] + " " + DP[1][N] + "\n");
            T--;
        }

        // output
        System.out.println(ans);
    }

    public static int f(int n) {
        if (n == 0) {
            System.out.println("0");
            return 0;
        } else if (n == 1) {
            System.out.println("1");
            return 1;
        } else {
            return f(n - 1) + f(n - 2);
        }
    }
}