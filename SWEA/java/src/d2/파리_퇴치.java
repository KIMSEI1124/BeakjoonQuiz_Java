package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파리_퇴치 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;
    private static int n, m;    /* 배열의 크기, 파리체의 크기 */
    private static int[][] array;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            answer.append("#").append(i).append(" ").append(getResult()).append("\n");
        }

        System.out.println(answer);
    }

    private static int getResult() throws IOException {
        input();
        return solve();
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int solve() {
        int max = 0;
        for (int i = 1; i <= n - m + 1; i++) {
            for (int j = 1; j <= n - m + 1; j++) {
                max = Math.max(max, getSum(i, j));
            }
        }
        return max;
    }

    private static int getSum(int y, int x) {
        int sum = 0;
        for (int i = y; i < y + m; i++) {
            for (int j = x; j < x + m; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }
}
