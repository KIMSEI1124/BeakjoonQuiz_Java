import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q9205 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static int t;
    private static int n;
    private static List<Pos> list;
    private static Queue<Pos> queue;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            input();
            solve();
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        queue = new ArrayDeque<>();
        for (int i = 0; i < n + 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (i == 0 || i == n + 1) {
                if (i == 0) { // 집의 좌표
                    queue.add(Pos.of(st, false));
                } else { // 락 페스티벌 좌표
                    list.add(Pos.of(st, true));
                }
                continue;
            }
            list.add(Pos.of(st, false));
        }
        visited = new boolean[list.size()];
    }

    private static void solve() {
        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            int y = pos.getY();
            int x = pos.getX();

            for (int i = 0; i < list.size(); i++) {
                Pos newPos = list.get(i);
                if (!visited[i] && newPos.canMove(y, x)) {
                    if (newPos.isRockFestival()) {
                        answer.append("happy").append("\n");
                        return;
                    }
                    visited[i] = true;
                    queue.add(newPos);
                }
            }
        }
        answer.append("sad").append("\n");
    }

    private static class Pos {
        private final int y;
        private final int x;
        private final boolean isRockFestival;

        private Pos(int y, int x, boolean isRockFestival) {
            this.y = y;
            this.x = x;
            this.isRockFestival = isRockFestival;
        }

        public static Pos of(StringTokenizer st, boolean isRockFestival) {
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            return new Pos(y, x, isRockFestival);
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        public boolean canMove(int y, int x) {
            return Math.abs(this.y - y) + Math.abs(this.x - x) <= 1_000;
        }

        public boolean isRockFestival() {
            return isRockFestival;
        }
    }
}
