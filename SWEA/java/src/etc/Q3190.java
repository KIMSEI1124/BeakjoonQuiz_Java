package d4;

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
    private static final int[] dy = {0, 1, 0, -1};
    private static final int[] dx = {1, 0, -1, 0};
    private static int direction = 0;   // 방향
    private static int n, k, l;   // 보드의 크기, 사과의 개수, 뱀의 방향 변환 횟수
    private static int[][] grid;
    private static Pos snakeHead = Pos.of(1, 1);
    private static Pos snakeTail = Pos.of(1, 1);
    private static int snakeLength = 1;
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
            StringTokenizer st = new StringTokenizer(br.readLine());    // 사과의 위치
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
        play(1, 1, 1);
    }

    private static void play(int timer, int y, int x) {
        String info = infos.get(timer);
        if (info != null) {
            turn(info);
        }

        int newY = y + dy[direction];   // 머리의 `y`좌표
        int newX = x + dx[direction];   // 머리의 `x`좌표

        if (canEnd(newY, newX)) {
            answer = timer;
            return;
        }

        eatApple(newY, newX);
//        snakes.addLast(Pos.of(newY, newX));
//        prevMove(newY, newX);
//        move();

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
        if (direction > 4) {    // 범위 초과시 0으로
            direction = 0;
        }
    }

    private static void turnLeft() {
        direction--;
        if (direction < 0) {    // 범위 초과시 3으로
            direction = 3;
        }
    }

    private static boolean canEnd(int y, int x) {
        /* 머리가 벽이나 자신의 몸에 부딪히면 종료 */
        return isOutOfRange(y, x) || grid[y][x] == SNAKE;
    }

    private static boolean isOutOfRange(int y, int x) {
        /* 벽 밖으로 이동시 true */
        return y < 1 || y >= n || x < 1 || x >= n;
    }

    private static void eatApple(int y, int x) {
        if (grid[y][x] == APPLE) {  // 사과를 먹으면
            snakeHead = Pos.of(y, x);
            snakeLength++;  // 몸의 길이를 증가
        }
    }

    private static void prevMove(Pos pos) {

    }

//    /* 움직이기 전에 뱀의 몸 위치를 저장한다. */
//    private static void prevMove(int y, int x) {
//        grid[y][x] = 0; // 뱀이 이동하여 `grid`에서 제거
//
//        if (snakeLength == snakes.size()) {    // 몸의 길이만큼 탐색하면 종료
//            return;
//        }
//
//        for (int i = 0; i < 4; i++) {
//            int newY = y + dy[i];
//            int newX = x + dx[i];
//
//            if (isOutOfRange(newY, newX)) {
//                continue;
//            }
//
//            if (grid[newY][newX] == SNAKE) {
//                snakes.addLast(Pos.of(newY, newX));
//                prevMove(newY, newX);
//                break;
//            }
//        }
//    }
//
//    private static void move() {
//        while (!snakes.isEmpty()) {
//            Pos pos = snakes.pollFirst();
//            int y = pos.getY();
//            int x = pos.getX();
//            grid[y][x] = SNAKE;
//        }
//        printGrid();
//    }

    private static void printGrid() {
        System.out.println("---------- GRID ----------");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
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

        @Override
        public String toString() {
            return "Pos{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }
}
