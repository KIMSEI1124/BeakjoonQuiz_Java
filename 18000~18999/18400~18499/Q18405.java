import java.io.*;
import java.util.*;

public class Q18405 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K, S, X, Y;
    static int[][] tube;
    static boolean[][] visited;
    static List<Integer> virus_list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 시험관의 정보 N * N
        K = Integer.parseInt(st.nextToken()); // 최대 바이러스의 id
        tube = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                tube[i][j] = Integer.parseInt(st.nextToken());
                if (!virus_list.contains(tube[i][j])) {
                    virus_list.add(tube[i][j]);
                }
            }
        }

        Collections.sort(virus_list);

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()); // S초 후
        X = Integer.parseInt(st.nextToken()); // X 좌표
        Y = Integer.parseInt(st.nextToken()); // Y 좌표

        // solve
        while (S > 0) {
            visited = new boolean[N][N]; // 초기화
            int virus_id;
            for (int i = 0; i < virus_list.size(); i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        virus_id = tube[j][k];
                        if (virus_list.get(i) == virus_id) {
                            dfs(j, k, virus_list.get(i));
                        }
                    }
                }
            }
            S--;
        }

        // output
        System.out.println(tube[X - 1][Y - 1]);
    }

    static int[] dy = { -1, 0, 0, 1 };
    static int[] dx = { 0, -1, 1, 0 };

    /**
     * DFS
     * 
     * @param y  y좌표
     * @param x  x좌표
     * @param id 바이러스 id
     */
    public static void dfs(int y, int x, int id) {
        if (visited[y][x]) {
            return;
        }
        visited[y][x] = true;
        int new_y;
        int new_x;
        for (int i = 0; i < 4; i++) { // 4방향 탐색
            new_y = y + dy[i];
            if (new_y < 0 || new_y >= N) {
                continue;
            }
            new_x = x + dx[i];
            if (new_x < 0 || new_x >= N) {
                continue;
            }
            if (tube[new_y][new_x] == id) { // 1. 동일한 바이러스 이면
                dfs(new_y, new_x, id);
            } else if (tube[new_y][new_x] == 0) { // 2. 바이러스가 없을 경우
                // 감염후 방문 확인
                tube[new_y][new_x] = id;
                visited[new_y][new_x] = true;
            }
        }
    }
}