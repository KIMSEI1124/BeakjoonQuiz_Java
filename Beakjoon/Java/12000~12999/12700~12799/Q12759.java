import java.io.*;
import java.util.*;

public class Q12759 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer;

    private static int player;
    private static Queue<Pos> queue;
    private static int[][] grid;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        player = Integer.parseInt(br.readLine());
        grid = new int[4][4];
        queue = new ArrayDeque<>();

        for (int i = 0; i < 9; i++) {
            queue.offer(new Pos(new StringTokenizer(br.readLine())));
        }
    }

    private static void solve() {
        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            grid[pos.y][pos.x] = player;

            player = player == 2 ? 1 : 2;
        }
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
    }

    private static boolean canEndGame(Pos pos) {
        int y = pos.y;
        int x = pos.x;
        if (y == 1 && x == 1) {

        }

        return false;
    }

    private static class Pos {
        int y;
        int x;

        public Pos(StringTokenizer st) {
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
        }
    }
}