import java.io.*;
import java.util.*;

public class Q16926 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    private static int n, m, r; // 배열의 세로 크기, 가로 크기, 회전 횟수
    private static int[][] array;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        print();
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        array = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void solve() {
        int loop = Math.min(n, m) / 2;
        for (int i = 0; i < loop; i++) {
            rotate(i, r);
        }
    }

    private static final int[] dy = { 1, 0, -1, 0 };
    private static final int[] dx = { 0, 1, 0, -1 };

    private static void rotate(int idx, int r) {
        Deque<Integer> queue = new ArrayDeque<>();

        /* y1, x1 회전 배열의 좌상단 */
        int y1 = idx;
        int x1 = idx;

        /* y2, x2 회전 배열의 우하단 */
        int y2 = n - idx;
        int x2 = m - idx;

        /* 탐색할 좌표 */
        int newY = y1;
        int newX = x1;
        /* 시계 방향 탐색 */
        for (int j = 0; j < 4;) {
            newY += dy[j];
            newX += dx[j];
            /* 범위를 벗어나면 idx를 증가하며 좌표 원복 */
            if (newY < y1 || newY >= y2 || newX < x1 || newX >= x2) {
                newY -= dy[j];
                newX -= dx[j];
                j++;
                continue;
            }
            queue.addLast(array[newY][newX]);
            /* 시작 지점으로 돌아오면 break */
            if (newY == y1 && newX == x1) {
                break;
            }
        }

        /* 최적화 - 제자리로 돌아오는 경우가 있어 반복적인 일을 최적화 */
        int loop = r % queue.size();

        /* 회전 */
        while (loop-- > 0) {
            queue.addFirst(queue.pollLast());
        }

        /* 배열 회전 */
        for (int j = 0; j < 4;) {
            newY += dy[j];
            newX += dx[j];
            /* 범위를 벗어나면 idx를 증가하며 좌표 원복 */
            if (newY < y1 || newY >= y2 || newX < x1 || newX >= x2) {
                newY -= dy[j];
                newX -= dx[j];
                j++;
                continue;
            }
            array[newY][newX] = queue.pollFirst();
            /* 시작 지점으로 돌아오면 break */
            if (newY == y1 && newX == x1) {
                break;
            }
        }
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer.append(array[i][j]).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}
