import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q3109 {
    private static final char SPACE = '.'; // 빈 공간
    private static final char BUILDING = 'x'; // 건물
    private static final char PIPE = 'p'; // 파이프 관

    /* 탐색 방향 */
    private static final int[] dy = { -1, 0, 1 };
    private static final int dx = 1;

    private static int answer; // 정답
    private static char[][] grid; // 도시의 정보
    private static boolean[][] visited;
    private static int n, m; // 세로, 가로의 길이
    private static boolean isEnd;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* 배열의 크기 입력 */
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        /* 배열 입력 */
        grid = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }
    }

    private static void solve() {
        /* 첫째 열에서 시작 */
        for (int i = 0; i < n; i++) {
            isEnd = false;
            recursive(i, 0);
        }

        getMaxPipe();
    }

    private static void recursive(int y, int x) {
        if (visited[y][x]) {
            return;
        }

        /* 방문 여부와 파이프 설치 */
        grid[y][x] = PIPE;
        visited[y][x] = true;

        /* 파이프가 끝까지 도달하면 파이프의 총 개수를 구하고 다른 파이프 라인 만들기 */
        if (x == m - 1) {
            isEnd = true;
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (isEnd) {
                return;
            }

            int newY = y + dy[i];
            int newX = x + dx;

            /* 배열 예외 처리, 빈 공간이 아닐 경우, 이미 방문한 곳 이면 `continue`처리 */
            if (newY < 0 || newY >= n || newX >= m || grid[newY][newX] == PIPE || grid[newY][newX] == BUILDING
                    || visited[newY][newX]) {
                continue;
            }

            recursive(newY, newX);
        }

        grid[y][x] = SPACE;
    }

    private static void getMaxPipe() {
        int pipeQuantity = 0;
        for (int i = 0; i < n; i++) {
            if (grid[i][m - 1] == PIPE) {
                pipeQuantity++;
            }
        }
        answer = Math.max(answer, pipeQuantity);
    }

    private static void print(int y, int x) {
        System.out.println("===== y :" + y + ", x :" + x);
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }
}
