import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q3190 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int APPLE = 1;
    private static final int SNAKE = 2;
    /* 뱀의 방향 변환 정보 Key : 시간, Value : 방향 변환 */
    private static final Map<Integer, String> infos = new HashMap<>();
    /* 뱀 위치 */
    private static final Deque<Pos> snakes = new ArrayDeque<>();
    /* 시계 방향으로 회전 +1, 반시계 방향으로 회전 -1 */
    private static final int[] dy = { 0, 1, 0, -1 };
    private static final int[] dx = { 1, 0, -1, 0 };
    private static boolean isEatApple;
    private static int direction = 0; // 방향
    private static int n, k, l; // 보드의 크기, 사과의 개수, 뱀의 방향 변환 횟수
    private static int[][] grid;
    private static int answer;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        grid = new int[n + 1][n + 1];
        grid[1][1] = SNAKE;

        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 사과의 위치
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            grid[y][x] = APPLE;
        }

        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String turn = st.nextToken();
            infos.put(time, turn);
        }
    }

    private static void solve() {
        snakes.add(Pos.of(1, 1)); // 시작 위치 추가
        play(1, 1, 1);
    }

    private static void play(int timer, int y, int x) {
        int newY = y + dy[direction]; // 머리의 `y`좌표
        int newX = x + dx[direction]; // 머리의 `x`좌표

        /* 게임이 종료 되는지 확인 */
        if (canEnd(newY, newX)) {
            answer = timer;
            return;
        }

        /* 뱀이 사과를 먹을 수 있을 지 */
        eatApple(newY, newX);

        /* 이동 준비 */
        snakes.addFirst(Pos.of(newY, newX));

        /* 실제 이동 */
        move();

        /* 해당 시간초가 끝나고 머리를 돌릴 경우 */
        String info = infos.get(timer);
        if (info != null) {
            turn(info);
        }

        play(timer + 1, newY, newX);
    }

    private static void turn(String info) {
        if (info.equals("L")) { // 왼쪽으로 회전 ( -1 )
            turnLeft();
        }
        if (info.equals("D")) { // 오른쪽으로 회전 ( +1 )
            turnRight();
        }
    }

    private static void turnRight() {
        direction++;
        if (direction > 3) { // 범위 초과시 0으로
            direction = 0;
        }
    }

    private static void turnLeft() {
        direction--;
        if (direction < 0) { // 범위 초과시 3으로
            direction = 3;
        }
    }

    private static boolean canEnd(int y, int x) {
        /* 머리가 벽이나 자신의 몸에 부딪히면 종료 */
        return isOutOfRange(y, x) || grid[y][x] == SNAKE;
    }

    private static boolean isOutOfRange(int y, int x) {
        /* 벽 밖으로 이동시 true */
        return y < 1 || y > n || x < 1 || x > n;
    }

    private static void eatApple(int y, int x) {
        // 사과를 먹으면
        isEatApple = grid[y][x] == APPLE;
    }

    private static void move() {
        int count = snakes.size();

        while (count-- > 0) {
            Pos pos = snakes.pollFirst();
            int y = pos.getY();
            int x = pos.getX();

            /* 사과를 먹으면 마지막 살리고 아니며 없애기 */
            if (count == 0 && !isEatApple) {
                grid[y][x] = 0;
                continue;
            }

            grid[y][x] = SNAKE;
            snakes.addLast(pos);
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
