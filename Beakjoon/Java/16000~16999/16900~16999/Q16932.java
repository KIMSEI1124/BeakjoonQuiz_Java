import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * IDEA 1: 0이 아닌 모든 곳에서 탐색을 `DFS`로 탐색
 * 결과 : 시간 초과 ( 4% )
 */

/*
 * IDEA 2: 0이 아닌 곳에서 `Key, Value`로 `Map`에 `id`와 `size`를 저장
 * 결과 : 시간 초과 ( 94% )
 */

/*
 * IDEA 3: Java 8이 Java 11보다 빠르다.. Java 8로 도전
 * 결과 : 성공
 * 시간 : 4120ms
 * 메모리 : 217928kB
 */
public class Q16932 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] dx = { 0, -1, 1, 0 };
    private static final int[] dy = { -1, 0, 0, 1 };
    private static int answer;
    private static int N; // ROW (2 <= N <= 1,000)
    private static int M; // COL (2 <= M <= 1,000)
    private static Map<Integer, Integer> size; // Key : id, Value : Quantity
    private static int[][] grid;
    private static int quantity;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        /* 배열 초기화 및 입력 */
        grid = new int[N][M];
        size = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void solve() {
        int id = 2; // 해당 위치들의 고유 식별자
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                /* 탐색 도중 `0`이 나오면 실행 */
                if (grid[i][j] == 0) {
                    /* 모양의 크기와 탐색한 위치를 저장 */
                    int count = 0;
                    Set<Integer> isSelect = new HashSet<>();
                    /* 4방향 탐색 */
                    for (int d = 0; d < 4; d++) {
                        int y = i + dy[d];
                        int x = j + dx[d];
                        /* 배열을 초과하거나 이미 선택한 영역이거나 `0`인 곳은 종료 */
                        if (y < 0 || y >= N || x < 0 || x >= M || grid[y][x] == 0 || isSelect.contains(grid[y][x])) {
                            continue;
                        }
                        /* 만약 탐색한 위치가 `1`이라면 `DFS` 탐색을 진행 */
                        if (grid[y][x] == 1) {
                            quantity = 0;
                            dfs(Pos.of(y, x), id);
                            size.put(id++, quantity);
                        }
                        /* 선택했다는 표시와 영역의 크기를 더하기 */
                        isSelect.add(grid[y][x]);
                        count += size.get(grid[y][x]);
                    }
                    /* `+1` 하는 이유는 자기 자신을 더하는 것 */
                    answer = Math.max(count + 1, answer);
                }
            }
        }
    }

    private static void dfs(Pos pos, int id) {
        /* 방문 여부 및 체크 */
        quantity++;
        grid[pos.getY()][pos.getX()] = id;

        for (int i = 0; i < 4; i++) {
            int newY = pos.getY() + dy[i];
            int newX = pos.getX() + dx[i];

            /* 범위를 벗어나거나 이미 방문한 경우, `1`인 경우에는 탐색을 종료 */
            if (newY < 0 || newY >= N || newX < 0 || newX >= M || grid[newY][newX] != 1) {
                continue;
            }
            dfs(Pos.of(newY, newX), id);
        }
    }

    private static class Pos {
        private final int y;
        private final int x;

        private Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public static Pos of(int y, int x) {
            return new Pos(y, x);
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }
}