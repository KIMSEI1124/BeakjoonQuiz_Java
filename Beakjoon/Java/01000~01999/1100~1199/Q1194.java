import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1194 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] dy = { 0, -1, 1, 0 };
    private static final int[] dx = { -1, 0, 0, 1 };
    private static final char WALL = '#';
    private static final char EXIT = '1';
    private static final Set<Character> keys = new HashSet<>(List.of('a', 'b', 'c', 'd', 'e', 'f'));
    private static final Set<Character> doors = new HashSet<>(List.of('A', 'B', 'C', 'D', 'E', 'F'));
    /* 문제 관련 변수 */
    private static int answer = -1;
    private static int n, m;
    private static char[][] area;
    private static int[][] bit;
    private static Queue<User> queue;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        queue = new ArrayDeque<>();
        bit = new int[n][m];
        area = new char[n][m];
        for (int i = 0; i < n; i++) {
            area[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (area[i][j] == '0') {
                    queue.offer(User.of(i, j, 1 << 1, 0));
                    bit[i][j] = queue.peek().getBit();
                }
            }
        }
    }

    private static void solve() {
        while (!queue.isEmpty()) {
            User user = queue.poll();
            int y = user.getY();
            int x = user.getX();
            if (area[y][x] == EXIT) {
                answer = user.getCount();
                break;
            }
            for (int i = 0; i < 4; i++) {
                int newY = y + dy[i];
                int newX = x + dx[i];
                if (newY < 0 || newY >= n ||
                        newX < 0 || newX >= m ||
                        area[newY][newX] == WALL ||
                        user.isVisited(bit[newY][newX])) {
                    continue;
                }
                /* 열쇠가 없을 때 */
                int userBit = user.getBit();
                if (doors.contains(area[newY][newX]) && user.hasNotKey(1 << area[newY][newX] - 'A' + 2)) {
                    continue;
                }
                /* 열쇠를 먹었을 때 */
                if (keys.contains(area[newY][newX])) {
                    userBit = userBit | 1 << area[newY][newX] - 'a' + 2;
                }
                bit[newY][newX] = userBit;
                queue.offer(User.of(newY, newX, userBit, user.getCount() + 1));
            }
        }
    }

    private static class User {
        private final int y;
        private final int x;
        private final int bit;
        private final int count;

        private User(int y, int x, int bit, int count) {
            this.y = y;
            this.x = x;
            this.bit = bit;
            this.count = count;
        }

        public static User of(int y, int x, int bit, int count) {
            return new User(y, x, bit, count);
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public int getBit() {
            return bit;
        }

        public int getCount() {
            return count;
        }

        public boolean isVisited(int other) {
            return (bit & other) == bit;
        }

        public boolean hasNotKey(int doorBit) {
            return (bit & doorBit) != doorBit;
        }
    }
}
