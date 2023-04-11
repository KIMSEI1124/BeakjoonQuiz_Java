import java.io.*;
import java.util.*;

public class Q2573 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder ans = new StringBuilder();
    static int N, M;
    static int[][] iceberg;
    static boolean[][] vistied;

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        iceberg = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // solve
        boolean run = true;
        int year = 0, count;
        while (run) {
            count = 0;
            vistied = new boolean[N][M];
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (iceberg[i][j] != 0) {
                        if(count != 0) {
                            ans.append(year);
                            run = false;
                        } else {
                            count++;
                            dfs(i, j);
                        }
                    }
                }
            }
            if(count == 0) {
                ans.append("0");
                run = false;
            }
            for (int i = 0; i < N; i++) {
                System.out.println(Arrays.toString(iceberg[i]));
            }
            year++;
        }

        // output
        System.out.println(ans);
    }

    static int[] dy = { -1, 0, 0, 1 };
    static int[] dx = { 0, -1, 1, 0 };

    public static void dfs(int y, int x) {
        if (vistied[y][x]) {
            return;
        }
        vistied[y][x] = true;
        melt(y, x);
        int new_y, new_x;
        for (int i = 0; i < 4; i++) {
            new_y = y + dy[i];
            if (new_y < 0 || new_y >= N) {
                continue;
            }
            new_x = x + dx[i];
            if (new_x < 0 || new_y >= M) {
                continue;
            }
            if (iceberg[new_y][new_x] != 0) {
                dfs(new_y, new_x);
            }
        }
    }

    public static void melt(int y, int x) {
        int heigth = iceberg[y][x];
        int new_y, new_x;
        for (int i = 0; i < 4; i++) {
            if (heigth == 0) {
                iceberg[y][x] = 0;
                return;
            }
            new_y = y + dy[i];
            if (new_y < 0 || new_y >= N) {
                continue;
            }
            new_x = x + dx[i];
            if (new_x < 0 || new_y >= M) {
                continue;
            }
            if (iceberg[new_y][new_x] == 0) {
                heigth--;
            }
        }
        iceberg[y][x] = heigth;
    }
}