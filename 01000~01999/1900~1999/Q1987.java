import java.io.*;
import java.util.*;

public class Q1987 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C, count = 0;
    static char[][] graph;
    static boolean[] visited = new boolean[(int) 'Z' - 'A' + 1];

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        for (int i = 0; i < R; i++) {
            graph[i] = br.readLine().replaceAll(" ", "").toCharArray();
        }

        // solve
        dfs(0, 0, 0);

        // output
        System.out.println(count);
    }

    static int[] dy = { -1, 0, 0, 1 };
    static int[] dx = { 0, -1, 1, 0 };

    public static void dfs(int y, int x, int depth) {
        if (visited[(int) graph[y][x] - 'A']) {
            return;
        }

        visited[(int) graph[y][x] - 'A'] = true;
        depth++;

        int new_y;
        int new_x;
        for (int i = 0; i < 4; i++) {
            new_y = y + dy[i];
            if (new_y < 0 || new_y >= R) {
                continue;
            }
            new_x = x + dx[i];
            if (new_x < 0 || new_x >= C) {
                continue;
            }
            dfs(new_y, new_x, depth);
        }

        visited[(int) graph[y][x] - 'A'] = false; // 백트래킹
        count = Math.max(depth, count);
    }
}