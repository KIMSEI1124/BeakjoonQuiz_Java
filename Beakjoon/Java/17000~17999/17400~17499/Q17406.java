
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q17406 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] dy = { 0, 1, 0, -1 };
    private static final int[] dx = { 1, 0, -1, 0 };
    private static int answer = Integer.MAX_VALUE;
    private static int n, m, k;
    private static int[][] array;
    private static Pos[] pos;

    public static void main(String[] args) throws IOException {
        input();
        perm(0, 0, array);
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로
        m = Integer.parseInt(st.nextToken()); // 가로
        k = Integer.parseInt(st.nextToken()); // 회전 연산의 개수

        array = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pos = new Pos[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            pos[i] = Pos.of(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
    }

    private static void perm(int cnt, int flag, int[][] array) {
        if (cnt == k) {
            answer = Math.min(answer, getMin(array));
            return;
        }

        for (int i = 0; i < k; i++) {
            if ((flag & 1 << i) != 0) {
                continue;
            }
            int[][] temp = rotate(array, pos[i]);
            perm(cnt + 1, flag | 1 << i, temp);
        }
    }

    private static int getMin(int[][] temp) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, Arrays.stream(temp[i]).sum());
        }
        return min;
    }

    private static int[][] rotate(int[][] array, Pos pos) {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(array[i], 0, temp[i], 0, m);
        }

        /* 회전 배열의 좌상단 좌표 */
        int y1 = pos.getY() - pos.getS() - 1;
        int x1 = pos.getX() - pos.getS() - 1;
        /* 회전 배열의 우하단 좌표 */
        int y2 = pos.getY() + pos.getS() - 1;
        int x2 = pos.getX() + pos.getS() - 1;

        Deque<Integer> queue = new ArrayDeque<>(); // 배열 회전 큐
        int rotateCount = Math.min(y2 - y1, x2 - x1) / 2; // 배열 회전 횟수
        for (int i = 0; i < rotateCount; i++) {
            int minY = y1 + i;
            int minX = x1 + i;
            int maxY = y2 - i;
            int maxX = x2 - i;
            int y = minY;
            int x = minX;
            int idx = 0;
            while (idx < 4) {
                y += dy[idx];
                x += dx[idx];
                /* 범위를 벗어나면 방향 변경 및 좌표 복귀 */
                if (y < minY || y > maxY || x < minX || x > maxX) {
                    y -= dy[idx];
                    x -= dx[idx];
                    idx++;
                    continue;
                }
                queue.addLast(array[y][x]);
                /* 시작 지점으로 돌아오면 종료 */
                if (y == minY && x == minX) {
                    break;
                }
            }

            queue.addFirst(queue.pollLast());
            idx = 0;
            while (idx < 4) {
                y += dy[idx];
                x += dx[idx];
                /* 범위를 벗어나면 방향 변경 및 좌표 복귀 */
                if (y < minY || y > maxY || x < minX || x > maxX) {
                    y -= dy[idx];
                    x -= dx[idx];
                    idx++;
                    continue;
                }
                temp[y][x] = queue.pollFirst();
                /* 시작 지점으로 돌아오면 종료 */
                if (y == minY && x == minX) {
                    break;
                }
            }
        }

        return temp;
    }

    private static class Pos {
        private final int y;
        private final int x;
        private final int s;

        private Pos(int y, int x, int s) {
            this.y = y;
            this.x = x;
            this.s = s;
        }

        public static Pos of(int y, int x, int s) {
            return new Pos(y, x, s);
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public int getS() {
            return s;
        }

        @Override
        public String toString() {
            return "y : " + y + ", x : " + x + ", s : " + s;
        }
    }
}
