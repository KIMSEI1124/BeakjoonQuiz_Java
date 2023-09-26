import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 시간: 124ms
 * 메모리: 14244KB
 * 풀이 방법: 물과 고슴도치의 큐를 따로 두고 `BFS`를 구현합니다.
 */
public class Q3055 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    /* 문제 변수 */
    private static final char WATER = '*';
    private static final char STONE = 'X';
    private static final char EXIT = 'D';
    private static final char VISITED = 'V';

    private static final int[] dy = { -1, 0, 0, 1 };
    private static final int[] dx = { 0, -1, 1, 0 };

    private static String answer = "KAKTUS";
    private static int R, C;

    private static char[][] area;
    private static Queue<Pos> beaverQueue;
    private static Queue<Pos> waterQueue;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        area = new char[R][C];
        beaverQueue = new ArrayDeque<>();
        waterQueue = new ArrayDeque<>();

        for (int r = 0; r < R; r++) {
            char[] temp = br.readLine().toCharArray();
            for (int c = 0; c < C; c++) {
                area[r][c] = temp[c];
                if (area[r][c] == 'S') {
                    beaverQueue.offer(Pos.of(r, c, 0));
                    area[r][c] = VISITED;
                }
                if (area[r][c] == WATER) {
                    waterQueue.offer(Pos.of(r, c, 0));
                }
            }
        }
    }

    private static void solve() {
        while (!beaverQueue.isEmpty()) {
            Pos beaver = beaverQueue.poll();
            int y = beaver.getY();
            int x = beaver.getX();

            /* 비버의 `count`가 물보다 크면 물이 참 (비버가 다 움직이고난 뒤 물이 참 ) */
            while (!waterQueue.isEmpty() && beaver.getCount() > waterQueue.peek().getCount()) {
                Pos water = waterQueue.poll();

                for (int i = 0; i < 4; i++) {
                    int newY = water.getY() + dy[i];
                    int newX = water.getX() + dx[i];

                    if (newY < 0 || newY >= R || newX < 0 || newX >= C ||
                            area[newY][newX] == STONE || area[newY][newX] == EXIT ||
                            area[newY][newX] == WATER) { // 좌표를 벗어나거나 돌, 비버의 굴, 물인 경우는 제외
                        continue;
                    }

                    area[newY][newX] = WATER;
                    waterQueue.offer(Pos.of(newY, newX, water.getCount() + 1));
                }
            }

            if (area[y][x] == WATER) { // 물에 도달하면 스킵
                continue;
            }

            for (int i = 0; i < 4; i++) { // 탐색 진행
                int newY = y + dy[i];
                int newX = x + dx[i];

                /* 범위를 벗어나거나 돌, 물, 방문한 지점인 경우는 제외 */
                if (newY < 0 || newY >= R || newX < 0 || newX >= C ||
                        area[newY][newX] == STONE || area[newY][newX] == WATER || area[newY][newX] == VISITED) {
                    continue;
                }

                if (area[newY][newX] == EXIT) { // 비버굴에 도착하면 종료
                    answer = String.valueOf(beaver.getCount() + 1);
                    return;
                }

                beaverQueue.offer(Pos.of(newY, newX, beaver.getCount() + 1));
                area[newY][newX] = VISITED;
            }
        }
    }

    private static class Pos {
        private final int y;
        private final int x;
        private final int count;

        private Pos(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }

        public static Pos of(int y, int x, int count) {
            return new Pos(y, x, count);
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public int getCount() {
            return count;
        }
    }
}
