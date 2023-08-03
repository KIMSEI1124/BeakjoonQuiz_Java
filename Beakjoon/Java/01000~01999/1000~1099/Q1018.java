import java.io.*;
import java.util.*;

public class Q1018 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int n, m;
    private static int[][] grid;

    public static void main(String[] args) throws IOException {
        /* Input */
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                grid[i][j] = inputElement(c[j]);
            }
            System.out.println(Arrays.toString(grid[i]));
        }

        /* Solve */
        int zero = getCount(0);
        int one = getCount(1);
        System.out.println(zero);
        System.out.println(one);
        int answer = Math.min(zero, one);
        System.out.println(answer);
    }

    private static int inputElement(char c) {
        if (c == 'W') {
            return 0;
        }
        return 1;
    }

    private static int getCount(int type) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int temp = grid[i][j] ^ type;
                if (temp != grid[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}