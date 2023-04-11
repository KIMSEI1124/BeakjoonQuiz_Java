import java.io.*;
import java.util.*;

public class Q24725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[][] mbti = {
            { "E", "I" },
            { "N", "S" },
            { "F", "T" },
            { "P", "J" } };
    static int N, M, answer = 0;
    static String[][] arr;
    static List<List<String>> check;

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N][M];
        check = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().split("");
        }

        // solve
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                solve(i, j);
                // int loop = 0;
                // dfs(i, j, loop);
            }
        }
        // 어떤 MBTI가 있는지 확인
        // for (int i = 0; i < check.size(); i++) {
        // System.out.println(check.get(i));
        // }

        // output
        System.out.println(check.size());
    }

    // 처음에는 4방향으로 탐색을 해보려했지만 실패
    static int[][] dy = {
            { 0, -1, -2, -3 }, { 0, -1, -2, -3 }, { 0, -1, -2, -3 },
            { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
            { 0, 1, 2, 3 }, { 0, 1, 2, 3 }, { 0, 1, 2, 3 } };
    static int[][] dx = {
            { 0, -1, -2, -3 }, { 0, 0, 0, 0 }, { 0, 1, 2, 3 },
            { 0, -1, -2, -3 }, { 0, 1, 2, 3 },
            { 0, -1, -2, -3 }, { 0, 0, 0, 0 }, { 0, 1, 2, 3 } };

    public static void solve(int y, int x) {
        for (int i = 0; i < dy.length; i++) { // 8방향 탐색
            List<String> mem = new ArrayList<>();
            for (int j = 0; j < dy[i].length; j++) { // MBTI 탐색
                if (mem.size() == j) {  // 성능 최적화
                    int new_y = y + dy[i][j];
                    int new_x = x + dx[i][j];
                    if (new_y < 0 || new_y >= N) { // y축 에러
                        continue;
                    }
                    if (new_x < 0 || new_x >= M) { // x축 에러
                        continue;
                    }
                    String word_mbti = arr[new_y][new_x]; // 검색할 MBTI
                    for (int k = 0; k < mbti[mem.size()].length; k++) {
                        String check_mbti = mbti[mem.size()][k]; // 정답 MBTI
                        if (word_mbti.equals(check_mbti)) { // 두 단어가 동일하면
                            mem.add(check_mbti);
                            break;
                        }
                    }
                    if (mem.size() == 4) { // 길이가 4가 되면
                        check.add(mem);
                    }
                }
            }
        }
    }

    /**
     * dfs로 탐색하면서 풀려고 했으나 실패
     * 
     * @param y    y좌표
     * @param x    x좌표
     * @param loop 몇번의 루프를 돌았는지 min = 0 , max = 3
     */
    static int[] dx_dfs = { 1, 1, 1, 0 };
    static int[] dy_dfs = { -1, 0, 1, 1 };

    public static void dfs(int y, int x, int loop) {
        for (int i = 0; i < dx.length; i++) {
            int new_y = y + dy_dfs[i];
            int new_x = x + dx_dfs[i];
            if (new_y < 0 || new_y >= N) {
                continue;
            }
            if (new_x < 0 || new_x >= M) {
                continue;
            }
            for (int j = 0; j < mbti[i].length; j++) {
                String word_mbti = arr[new_y][new_x];
                if (word_mbti.equals(mbti[loop][j])) {
                    if (loop == 3) {
                        answer++;
                    } else {
                        loop++;
                        dfs(y, x, loop);
                    }
                }
            }
        }
    }
}