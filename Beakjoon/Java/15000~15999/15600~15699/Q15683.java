import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q15683 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int SPACE = 0;
    private static final int TYPE_ONE = 1;
    private static final int TYPE_TWO = 2;
    private static final int TYPE_THREE = 3;
    private static final int TYPE_FOUR = 4;
    private static final int TYPE_FIVE = 5;
    private static final int WALL = 6;
    private static final int SPOT = 9;
    private static final Map<Integer, Camera> CCTV = new HashMap<>(); // Key : CCTV_ID, Value : Camera ( 좌표 )
    private static final int[] dy = { -1, 0, 1, 0 };
    private static final int[] dx = { 0, -1, 0, 1 };
    private static int answer = Integer.MAX_VALUE;
    private static int n;
    private static int m;
    private static int[][] grid;
    private static int totalSpace;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        /* 맵 입력받기 */
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                /* 벽이거나 빈 공간인 경우 `continue` */
                if (canContinue(i, j)) {
                    /* 만약 빈 공간인 경우에는 `totalSpace` 값 증가 */
                    increaseTotalSpace(i, j);
                    continue;
                }
                CCTV.put(CCTV.size(), Camera.of(i, j, grid[i][j]));
            }
        }
    }

    private static boolean canContinue(int i, int j) {
        return grid[i][j] == SPACE || grid[i][j] == WALL;
    }

    private static void increaseTotalSpace(int i, int j) {
        if (grid[i][j] == SPACE) {
            totalSpace++;
        }
    }

    private static void solve() {
        recursive(0, new Camera[CCTV.size()]);
    }

    private static void recursive(int count, Camera[] cameras) {
        /* CCTV 선택이 완료되면 */
        if (count == CCTV.size()) {
            int blindSpotCount = getBlindSpotCount(cameras, copyGrid());
            answer = Math.min(blindSpotCount, answer);
            return;
        }

        cameras[count] = CCTV.get(count);

        /* 4방향 탐색 */
        for (int i = 0; i < 4; i++) {
            /* 다음 카메라 탐색 */
            recursive(count + 1, cameras);
            cameras[count].increaseDirection();
        }
    }

    private static int getBlindSpotCount(Camera[] cameras, int[][] grid) {
        /* 사각 지대의 개수 구하기 */
        int blindSpotCount = totalSpace;

        /* 카메라가 탐지할 수 있는 범위 구하기 */
        for (Camera camera : cameras) {
            blindSpotCount -= getDetectSpot(camera, grid);
        }
        return blindSpotCount;
    }

    private static int getDetectSpot(Camera camera, int[][] grid) {
        int totalSpot = 0;
        if (camera.getType() == TYPE_ONE) {
            return getTotalSpotByTypeOne(camera, grid);
        }
        if (camera.getType() == TYPE_TWO) {
            totalSpot += getTotalSpotByTypeTwo(camera, grid);
            return totalSpot;
        }
        if (camera.getType() == TYPE_THREE) {
            totalSpot += getTotalSpotByTypeThree(camera, grid);
            return totalSpot;
        }
        if (camera.getType() == TYPE_FOUR) {
            totalSpot += getTotalSpotByTypeFour(camera, grid);
            return totalSpot;
        }
        return getTotalSpotByTypeFive(camera, grid);
    }

    private static int getTotalSpotByTypeOne(Camera camera, int[][] grid) {
        return searchSpot(camera, grid, camera.getDirection());
    }

    private static int getTotalSpotByTypeTwo(Camera camera, int[][] grid) {
        int totalSpot = 0;
        for (int i = 0; i <= 2; i += 2) {
            totalSpot += searchSpot(camera, grid, camera.getDirection() + i);
        }
        return totalSpot;
    }

    private static int getTotalSpotByTypeThree(Camera camera, int[][] grid) {
        int totalSpot = 0;
        for (int i = 0; i <= 1; i++) {
            totalSpot += searchSpot(camera, grid, camera.getDirection() + i);
        }
        return totalSpot;
    }

    private static int getTotalSpotByTypeFour(Camera camera, int[][] grid) {
        int totalSpot = 0;
        for (int i = 0; i <= 2; i++) {
            totalSpot += searchSpot(camera, grid, camera.getDirection() + i);
        }
        return totalSpot;
    }

    private static int getTotalSpotByTypeFive(Camera camera, int[][] grid) {
        int totalSpot = 0;
        for (int i = 0; i < 4; i++) {
            totalSpot += searchSpot(camera, grid, i);
        }
        return totalSpot;
    }

    private static int searchSpot(Camera camera, int[][] grid, int i) {
        int totalSpot = 0;
        int range = 1;
        while (true) {
            int newY = camera.getY() + dy[i % 4] * range;
            int newX = camera.getX() + dx[i % 4] * range;

            /* 해당 좌표의 값이 정상적인지 확인 */
            if (canBreak(newY, newX)) {
                break;
            }

            /* 탐지 거리 늘리기 */
            range++;

            /* 감시한 영역이면 `continue` */
            if (grid[newY][newX] == SPOT || grid[newY][newX] != SPACE) {
                continue;
            }
            grid[newY][newX] = SPOT;
            totalSpot++;
        }
        return totalSpot;
    }

    private static boolean canBreak(int y, int x) {
        return y < 0 || y >= n || x < 0 || x >= m || grid[y][x] == WALL;
    }

    /* 배열 복사하기 */
    private static int[][] copyGrid() {
        int[][] copyGird = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyGird[i][j] = grid[i][j];
            }
        }
        return copyGird;
    }

    private static class Camera {
        private final int y;
        private final int x;
        private final int type;
        private int direction;

        private Camera(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }

        public static Camera of(int y, int x, int type) {
            return new Camera(y, x, type);
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public int getType() {
            return type;
        }

        public int getDirection() {
            return direction;
        }

        public void increaseDirection() {
            direction++;
        }
    }
}
