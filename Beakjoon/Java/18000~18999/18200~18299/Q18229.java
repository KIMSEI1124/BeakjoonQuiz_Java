import java.io.*;
import java.util.*;

public class Q18229 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    private static int N, M, K;
    private static int[][] arr;
    private static int[] hands;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        hands = new int[N + 1];
    }

    private static void solve() {
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                hands[j] += arr[j][i];
                if (hands[j] >= K) {
                    answer.append(j).append(" ").append(i);
                    return;
                }
            }
        }
    }
}