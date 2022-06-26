import java.io.*;
import java.util.*;

public class Q4963 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    /* w : 너비, h : 높이 */
    static int w, h;
    static int[][] sea;
    static boolean[][] visted;

    public static void main(String[] args) throws IOException {
        while (true) {
            // input
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w + h == 0) { // 종료 조건
                break;
            }
            int count = 0;
            sea = new int[h][w];
            visted = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    sea[i][j] = num;
                    if (num == 1) {
                        visted[i][j] = true; // 방문 해야함
                    }
                }
            }

            // solve
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (visted[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            ans.append(count).append("\n");
        }

        // output
        System.out.println(ans);
    }

    // 상 하 좌 우
    static int[] x_calc = { -1, 0, 1, -1, 1, -1, 0, 1 };
    static int[] y_calc = { -1, -1, -1, 0, 0, 1, 1, 1 };

    static public void dfs(int y, int x) {
        if (!visted[y][x]) {
            return;
        }
        visted[y][x] = false;
        for (int i = 0; i < x_calc.length; i++) {
            int x_pos = x + x_calc[i];
            int y_pos = y + y_calc[i];
            // 에러 체크
            if (x_pos < 0 || x_pos >= w) {
                continue;
            }
            if (y_pos < 0 || y_pos >= h) {
                continue;
            }
            if (visted[y_pos][x_pos]) {
                dfs(y_pos, x_pos);
            }
        }
        return;
    }
}