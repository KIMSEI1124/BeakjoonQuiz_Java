import java.io.*;
import java.util.*;

public class Q2178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static char[][] maze;
    static boolean[][] visted;
    static Queue<pos<Integer, Integer>> maze_pos;

    public static void main(String[] args) throws IOException {
        // input
        int ans = 0;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new char[N + 1][M + 1];
        visted = new boolean[N + 1][M + 1];
        maze_pos = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            maze[i] = br.readLine().toCharArray();
            // system.out.println("i: \"" + i + "\" > " + Arrays.toString(maze[i]) + "\"");
        }

        // solve
        pos<Integer, Integer> start_pos = new pos<>();
        start_pos.set_pos(0, 0);
        maze_pos.add(start_pos);
        visted[start_pos.get_y_pos()][start_pos.get_x_pos()] = true;
        while (true) {
            int x_pos = maze_pos.peek().get_x_pos();
            int y_pos = maze_pos.poll().get_y_pos();
            if (y_pos == N && x_pos == M) {
                break;
            }
        }

        // output
        System.out.println(ans);
    }

    static int[] x = { 0, 0, -1, 1 };
    static int[] y = { -1, 1, 0, 0 };

    static public void bfs(int y, int x) {
        if (visted[y][x] == true) {
            return;
        }
    }
}

class pos<x, y> {
    private int x;
    private int y;

    public void set_pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int get_x_pos() {
        return this.x;
    }

    public int get_y_pos() {
        return this.y;
    }
}