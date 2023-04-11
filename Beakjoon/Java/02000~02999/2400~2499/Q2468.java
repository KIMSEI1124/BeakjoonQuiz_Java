import java.io.*;
import java.util.*;

public class Q2468 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int ans;
    static int N;
    static int[][] area;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        // input
        ans = 0;
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                area[i][j] = height;
            }
        }

        // solve
        for (int i = 0; i <= 100; i++) { // 빗물의 높이
            int count = 0;
            visited = new boolean[N][N];
            for (int j = 0; j < N; j++) { // y
                for (int k = 0; k < N; k++) { // x
                    if (area[j][k] > i && visited[j][k] == false) {
                        count++;
                        dfs(i, j, k);
                    }
                }
            }
            if (count >= Math.max(ans, count)) {
                ans = count;
            }
        }

        // output
        System.out.println(ans);
    }

    static int[] dy = { -1, 0, 0, 1 };
    static int[] dx = { 0, -1, 1, 0 };

    static public void dfs(int height, int y, int x) {
        if (area[y][x] <= height || visited[y][x] == true) {
            return;
        }
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) { // 4방향 탐색
            int new_y = y + dy[i];
            int new_x = x + dx[i];
            if (new_y < 0 || new_y >= N)
                continue;
            if (new_x < 0 || new_x >= N)
                continue;
            dfs(height, new_y, new_x);
        }
    }
}