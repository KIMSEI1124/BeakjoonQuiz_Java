import java.io.*;
import java.util.*;

public class Q1010 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static int T, N, M;
    static int[][] DP = new int[30][30];

    public static void main(String[] args) throws IOException {
        // input
        T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        // solve
        for (int i = 1; i < 30; i++) {
            for (int j = i; j < 30; j++) {
                if (i == 1) {
                    DP[i][j] = j;
                } else {
                    DP[i][j] = DP[i][j - 1] + DP[i - 1][j - 1];
                }
            }
        }

        while (T > 0) {
            T--;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 강 서쪽
            M = Integer.parseInt(st.nextToken()); // 강 동쪽
            ans.append(DP[N][M]).append("\n");
        }

        // output
        System.out.println(ans);
    }
}