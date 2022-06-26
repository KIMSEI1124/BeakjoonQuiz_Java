import java.io.*;
import java.util.*;

public class Q1012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    static int T; // 테스트 케이스 수
    static int M; // 농장의 가로 길이
    static int N; // 농장의 세로 길이
    static int K; // 배추가 심어져있는 위치
    /* true : 배추가 심어져 있습니다, false : 이미 방문하였거나, 배추가 없습니다. */
    static boolean[][] farm; // 농장과 방문 여부

    public static void main(String[] args) throws IOException {
        // input
        T = Integer.parseInt(br.readLine());
        // solve
        while (T > 0) {
            // input
            T--;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            farm = new boolean[N][M];
            int count = 0;
            while (K > 0) {
                st = new StringTokenizer(br.readLine());
                int x_pos = Integer.parseInt(st.nextToken());
                int y_pos = Integer.parseInt(st.nextToken());
                farm[y_pos][x_pos] = true;
                K--;
            }
            // solve
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (farm[i][j]) {
                        dfs(j, i);
                        count++;
                    }
                }
            }
            ans.append(count).append("\n");
        }

        // output
        System.out.println(ans);
    }

    static public void dfs(int x_pos, int y_pos) {
        if (!farm[y_pos][x_pos]) {
            return;
        }
        farm[y_pos][x_pos] = false;
        // 상 하 좌 우 탐색
        if (up_serach(x_pos, y_pos))
            dfs(x_pos, y_pos - 1);
        if (down_serach(x_pos, y_pos))
            dfs(x_pos, y_pos + 1);
        if (left_serach(x_pos, y_pos))
            dfs(x_pos - 1, y_pos);
        if (right_serach(x_pos, y_pos))
            dfs(x_pos + 1, y_pos);
        return;
    }

    static public boolean up_serach(int x_pos, int y_pos) {
        if (y_pos == 0) { // 에러 방지
            return false;
        }
        if (farm[y_pos - 1][x_pos]) {
            return true;
        }
        return false;
    }

    static public boolean down_serach(int x_pos, int y_pos) {
        if (y_pos == N - 1) { // 에러 방지
            return false;
        }
        if (farm[y_pos + 1][x_pos]) {
            return true;
        }
        return false;
    }

    static public boolean left_serach(int x_pos, int y_pos) {
        if (x_pos == 0) { // 에러 방지
            return false;
        }
        if (farm[y_pos][x_pos - 1]) {
            return true;
        }
        return false;
    }

    static public boolean right_serach(int x_pos, int y_pos) {
        if (x_pos == M - 1) { // 에러 방지
            return false;
        }
        if (farm[y_pos][x_pos + 1]) {
            return true;
        }
        return false;
    }
}