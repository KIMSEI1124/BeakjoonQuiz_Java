package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상호의_배틀필드 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();

    /* 맵 정보 */
    private static final char LAND = '.';
    private static final char BRICK = '*';
    private static final char WALL = '#';
    private static final char WATER = '-';
    private static final char UP_TANK = '^';
    private static final char DOWN_TANK = 'v';
    private static final char LEFT_TANK = '<';
    private static final char RIGHT_TANK = '>';

    /* 탱크 명령어 */
    private static final char UP = 'U';
    private static final char DOWN = 'D';
    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';
    private static final char SHOOT = 'S';

    /* 4방향 탐색 */
    private static final int[] dy = {-1, 0, 0, 1};
    private static final int[] dx = {0, -1, 1, 0};
    private static final int D_UP = 0;
    private static final int D_LEFT = 1;
    private static final int D_RIGHT = 2;
    private static final int D_DOWN = 3;

    /* 입력 정보 */
    private static int H, W, N;
    private static char[][] grid;
    private static char[] codes;

    /* 탱크 정보 */
    private static int tankY;
    private static int tankX;
    private static int tankDirection;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            input();
            solve();
            answer.append("#").append(i).append(" ").append(resultAppend());
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        /* 맵 정보 입력 */
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());   // 높이
        W = Integer.parseInt(st.nextToken());   // 폭

        grid = new char[H][W];
        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                grid[i][j] = input.charAt(j);

                /* 탱크 정보 초기화 */
                if (grid[i][j] == UP_TANK) {
                    setTank(i, j, D_UP);
                } else if (grid[i][j] == LEFT_TANK) {
                    setTank(i, j, D_LEFT);
                } else if (grid[i][j] == RIGHT_TANK) {
                    setTank(i, j, D_RIGHT);
                } else if (grid[i][j] == DOWN_TANK) {
                    setTank(i, j, D_DOWN);
                }
            }
        }

        /* 전차 명령어 입력 */
        N = Integer.parseInt(br.readLine());
        codes = br.readLine().toCharArray();
    }

    private static void setTank(int y, int x, int direction) {
        /* 탱크의 좌표와 방향을 저장 */
        tankY = y;
        tankX = x;
        tankDirection = direction;

        /* 탱크의 정보를 입력하였기 때문에 평지로 변경 */
        grid[y][x] = LAND;
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            char code = codes[i];

            if (code == SHOOT) {
                tankShoot();
                continue;
            }

            tankTurn(code);
            tankMove();
        }

        restoreTankByGrid();
    }

    private static void tankShoot() {
        int range = 1;
        while (true) {
            int newY = tankY + dy[tankDirection] * range;
            int newX = tankX + dx[tankDirection] * range;

            /* 포탄이 맵 밖으로 나가거나 강철벽에 맞으면 종료 */
            if (outOfRange(newY, newX) || grid[newY][newX] == WALL) {
                return;
            }

            /* 포탄이 평지와 물에 있으면 계속 진행 */
            if (grid[newY][newX] == LAND || grid[newY][newX] == WATER) {
                range++;
                continue;
            }

            /* 벽돌에 맞으면 평지로 변경하고 종료 */
            if (grid[newY][newX] == BRICK) {
                grid[newY][newX] = LAND;
            }
            return;
        }
    }

    private static void tankTurn(char code) {
        if (code == UP) {
            tankDirection = D_UP;
        } else if (code == LEFT) {
            tankDirection = D_LEFT;
        } else if (code == RIGHT) {
            tankDirection = D_RIGHT;
        } else if (code == DOWN) {
            tankDirection = D_DOWN;
        }
    }

    private static void tankMove() {
        int newY = tankY + dy[tankDirection];
        int newX = tankX + dx[tankDirection];

        /* 맵 밖으로 나가거나 평지가 아니면 움직이지 못함 */
        if (outOfRange(newY, newX) || grid[newY][newX] != LAND) {
            return;
        }

        tankY = newY;
        tankX = newX;
    }

    private static void restoreTankByGrid() {
        if (tankDirection == D_UP) {
            grid[tankY][tankX] = UP_TANK;
        } else if (tankDirection == D_LEFT) {
            grid[tankY][tankX] = LEFT_TANK;
        } else if (tankDirection == D_RIGHT) {
            grid[tankY][tankX] = RIGHT_TANK;
        } else if (tankDirection == D_DOWN) {
            grid[tankY][tankX] = DOWN_TANK;
        }
    }

    private static String resultAppend() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(grid[i][j]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private static boolean outOfRange(int y, int x) {
        return y < 0 || y >= H || x < 0 || x >= W;
    }
}
