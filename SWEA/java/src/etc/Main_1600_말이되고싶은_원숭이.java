package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고싶은_원숭이 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] dy = {-1, 0, 0, 1};
    private static final int[] dx = {0, -1, 1, 0};
    private static final int[] dy2 = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static final int[] dx2 = {-1, 1, -2, 2, -2, 2, -1, 1};
    private static StringTokenizer st;
    private static int k;
    private static int w;
    private static int h;

    private static int[][] grid;
    private static boolean[][][] visited;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void input() throws IOException {
        k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        grid = new int[h + 1][w + 1];
        visited = new boolean[k + 1][h + 1][w + 1];
        for (int i = 1; i <= h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= w; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void solve() {
        Queue<Pos> queue = new ArrayDeque<>();
        queue.offer(new Pos(1, 1, 0, 0));

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            if (pos.x == w && pos.y == h) {
                answer = Math.min(answer, pos.time);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int newY = pos.y + dy[i];
                int newX = pos.x + dx[i];
                if (newY < 1 || newY > h || newX < 1 || newX > w || grid[newY][newX] == 1 || visited[pos.count][newY][newX]) {
                    continue;
                }
                visited[pos.count][newY][newX] = true;
                queue.offer(new Pos(newY, newX, pos.count, pos.time + 1));
            }
            for (int i = 0; i < 8 && pos.count != k; i++) {
                int newY = pos.y + dy2[i];
                int newX = pos.x + dx2[i];
                if (newY < 1 || newY > h || newX < 1 || newX > w || grid[newY][newX] == 1 || visited[pos.count + 1][newY][newX]) {
                    continue;
                }
                visited[pos.count + 1][newY][newX] = true;
                queue.offer(new Pos(newY, newX, pos.count + 1, pos.time + 1));
            }
        }
    }


    private static class Pos {
        int y;
        int x;
        int count;
        int time;

        public Pos(int y, int x, int count, int time) {
            this.y = y;
            this.x = x;
            this.count = count;
            this.time = time;
        }
    }
}
