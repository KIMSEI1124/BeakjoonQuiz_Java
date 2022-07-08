import java.io.*;
import java.util.*;

public class Q7576 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans = 0;
    static StringTokenizer st;
    static int N, M; // 세로, 가로
    static int[][] warehouse; // 창고
    static boolean[][] visited; // 방문 여부
    static Queue<Pos7576<Integer, Integer>> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        warehouse = new int[M][N];
        visited = new boolean[M][N];
        int tomato = N * M;
        Pos7576<Integer, Integer> pos;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num != 0) {
                    tomato--; // tomato 계산을 위한 수식
                    if (num == 1) {
                        pos = new Pos7576<>();
                        pos.set_pos(j, i);
                        queue.add(pos);
                        visited[i][j] = true;
                    }
                }
                warehouse[i][j] = num;
            }
        }

        // solve
        int queue_size;
        int[] dy = { -1, 0, 0, 1 };
        int[] dx = { 0, -1, 1, 0 };
        while (!queue.isEmpty()) {
            ans++;
            queue_size = queue.size();
            for (int i = 0; i < queue_size; i++) {
                pos = queue.poll();
                int new_y; // 새로운 y좌표
                int new_x; // 새로운 x좌표
                Pos7576<Integer, Integer> new_pos = new Pos7576<>();
                for (int j = 0; j < 4; j++) {
                    new_y = pos.get_y() + dy[j];
                    if (new_y < 0 || new_y >= N) { // y값 확인
                        continue;
                    }
                    new_x = pos.get_x() + dx[j];
                    if (new_x < 0 || new_x >= M) { // x값 확인
                        continue;
                    }
                    if (warehouse[new_y][new_x] == 0) { // 아직 익지 않은 토마토
                        new_pos.set_pos(new_x, new_y);
                        queue.add(new_pos);
                        tomato--;
                    }
                }
            }
        }
        if (tomato != 0) {
            ans = -1;
        }
        System.out.println(tomato);

        // output
        System.out.println(ans);
    }
}

class Pos7576<x, y> {
    private int x;
    private int y;

    public void set_pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int get_x() {
        return this.x;
    }

    public int get_y() {
        return this.y;
    }
}