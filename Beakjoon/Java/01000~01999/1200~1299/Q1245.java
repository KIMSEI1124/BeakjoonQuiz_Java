import java.io.*;
import java.util.*;

public class Q1245 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans = 0;
    static StringTokenizer st;
    static int N, M;
    static int[][] mountain;
    static boolean[][] visited;
    static boolean[][] mountain_peak;

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mountain = new int[N][M];
        mountain_peak = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                mountain[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // solve
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (bfs(i, j, mountain[i][j])) {
                    mountain_peak[i][j] = true;
                    ans++;
                }
            }
        }

        // output
        System.out.println(ans);
    }

    static int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void dfs(int y, int x, int height) {  // 미완성
        if (visited[y][x]) {
            return;
        }
        visited[y][x] = true;
        int new_y;
        int new_x;
        for (int i = 0; i < 8; i++) {
            new_y = y + dy[i]; // y좌표
            if (new_y < 0 || new_y >= N) {
                continue;
            }
            new_x = x + dx[i]; // x좌표
            if (new_x < 0 || new_x >= M) {
                continue;
            }
            int new_height = mountain[new_y][new_x];
            if (new_height == height) {
                dfs(new_y, new_x, height);
            } else if (new_height > height) {
                return;
            }
        }
    }

    public static boolean bfs(int y, int x, int height) {
        Queue<Pos<Integer, Integer>> queue = new LinkedList<>();
        visited = new boolean[N][M];
        Pos<Integer, Integer> pos = new Pos<>();
        pos.set_pos(x, y);
        queue.add(pos);
        while (!queue.isEmpty()) {
            pos = queue.poll();
            int new_y;
            int new_x;
            int new_height;
            for (int i = 0; i < 8; i++) {
                new_y = pos.get_y() + dy[i];
                if (new_y < 0 || new_y >= N) {
                    continue;
                }
                new_x = pos.get_x() + dx[i];
                if (new_x < 0 || new_x >= M) {
                    continue;
                }
                if (visited[new_y][new_x]) { // 방문 확인
                    continue;
                }
                new_height = mountain[new_y][new_x];
                if (new_height == height) {
                    if (mountain_peak[new_y][new_x]) { // 산봉우리 중복 방지
                        return false;
                    }
                    pos.set_pos(new_x, new_y);
                    queue.add(pos);
                    visited[new_y][new_x] = true;
                } else if (new_height > height) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Pos<x, y> {
    private int x;
    private int y;

    public void set_pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int get_x() {
        return this.x;
    }

    public int get_y() {
        return this.y;
    }
}