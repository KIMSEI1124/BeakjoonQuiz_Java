import java.io.*;
import java.util.*;

public class Q2178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static char[][] maze;
    static boolean[][] visted;
    static List<Queue<pos<Integer, Integer>>> maze_pos;

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
        pos<Integer, Integer> pos = new pos<>();
        boolean run = true;
        while (run) {
            maze_pos.add(new LinkedList<>());
            if (maze_pos.size() == 0) { // 시작
                pos.set_pos(0, 0);
                visted[pos.get_y_pos()][pos.get_x_pos()] = true;
                maze_pos.get(maze_pos.size() - 1).add(pos);
            }
            System.out.println(maze_pos.get(maze_pos.size()-1).size());
            for (int i = 0; i < maze_pos.get(maze_pos.size() - 1).size(); i++) {
                int x_pos = maze_pos.get(maze_pos.size() - 1).peek().get_x_pos();
                int y_pos = maze_pos.get(maze_pos.size() - 1).poll().get_y_pos();
                if (y_pos == N + 1 && x_pos == M + 1) {
                    break;
                }
                bfs(y_pos, x_pos);
            }
        }

        // output
        System.out.println(maze_pos.size());
    }

    static int[] x_pos = { 0, 0, -1, 1 };
    static int[] y_pos = { -1, 1, 0, 0 };

    static public void bfs(int y, int x) {
        if (visted[y][x] == true) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int x_calc = x + x_pos[i];
            int y_calc = y + y_pos[i];
            if (x_calc < 0 || x_calc > M)
                continue;
            if (y_calc < 0 || y_calc > N)
                continue;
            if (maze[y_calc][x_calc] == '1' && visted[y_calc][x_calc] == false) {
                visted[y_calc][x_calc] = true;
                pos<Integer, Integer> pos = new pos<>();
                pos.set_pos(x_calc, y_calc);
                maze_pos.get(maze_pos.size() - 1).add(pos);
            }
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