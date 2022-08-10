import java.io.*;
import java.util.*;

public class Q14503 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static int N, M, r, c, d;
    static int[][] area;
    static boolean[][] vistied;

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine()); // N, M
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        st = new StringTokenizer(br.readLine()); // r, c, d
        r = Integer.parseInt(st.nextToken()); // x좌표
        c = Integer.parseInt(st.nextToken()); // y좌표
        d = Integer.parseInt(st.nextToken()); // 바라보는 방향, 0 : N, 1 : E, 2 : N, 3 : W

        area = new int[N][M];
        vistied = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // solve

        // output
        System.out.println(ans);
    }

    // 1. 현재 위치를 청소한다.
    public static void clean(int y, int x) {
        vistied[y][x] = true;
    }

    // 0 : 북, 1 : 동, 2 : 남, 3 : 서
    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    // 2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 탐색을 진행한다.
    public static void turn_left(int y, int x, int d) {
        if (d == 0) {
            d = 4;
        } else {
            d--;
        }
        int new_y = dy[d] + y;
        int new_x = dx[d] + x;
        if (area[new_y][new_x] != 1 && !vistied[new_y][new_x]) {
            // 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
            r = new_x;
            c = new_y;
            clean(c, r);
        } else {
            // 2.2. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
            turn_left(y, x, d);
        }
    }

    public static void search_clean(int y, int x) {

    }
}