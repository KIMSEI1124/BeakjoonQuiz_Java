import java.io.*;
import java.util.*;

public class Q2178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    static int[] dy = { -1, 0, 0, 1 };
    static int[] dx = { 0, -1, 1, 0 };

    static int N, M;
    static char[][] maze;
    static int[][] visited;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new char[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            maze[i] = br.readLine().toCharArray();
        }

        // solve
        // - setting
        int[] pos = { 0, 0 }; // y, x
        queue.add(pos);
        visited[0][0] = 1;

        // - bfs
        while (!queue.isEmpty()) {
            int[] now_pos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int new_y = now_pos[0] + dy[i];
                if (new_y < 0 || new_y >= N) { // y축 에러
                    continue;
                }
                int new_x = now_pos[1] + dx[i];
                if (new_x < 0 || new_x >= M) { // x축 에러
                    continue;
                }
                if (visited[new_y][new_x] != 0) { // 방문한 좌표
                    continue;
                }
                if (maze[new_y][new_x] == '1') {
                    int[] new_pos = { new_y, new_x };
                    queue.add(new_pos);
                    visited[new_y][new_x] = visited[now_pos[0]][now_pos[1]] + 1;
                }
            }
        }

        // output
        System.out.println(visited[N - 1][M - 1]);
    }
}