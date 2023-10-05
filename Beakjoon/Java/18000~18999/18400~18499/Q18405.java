import java.util.*;
import java.io.*;

public class Q18405 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int answer;

    private static int N, K; // N : 배열의 크기, K : 바이러스의 종류의 갯수
    private static int S, X, Y; // S : S초 뒤, X : X좌표, Y : Y좌표
    private static int[][] area;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        area = new int[N + 1][N + 1];
        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                area[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
    }

    private static int[] dy = { -1, 0, 0, 1 };
    private static int[] dx = { 0, -1, 1, 0 };

    private static void solve() {
        /* `id` 순서대로 넣기 -> `list`에 저장후 정렬 한 뒤 queue에 저장 */
        List<Virus> sortVirus = new ArrayList<>();
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (area[r][c] == 0) {
                    continue;
                }
                sortVirus.add(new Virus(area[r][c], r, c));
            }
        }
        Collections.sort(sortVirus);
        sortVirus.add(new Virus(-1, -1, -1)); // 더미 (1초 단위)

        /* BFS 탐색하면서 S초 만큼 돌리기 */
        Queue<Virus> queue = new ArrayDeque<>();
        for (int i = 0; i < sortVirus.size(); i++) {
            queue.offer(sortVirus.get(i));
        }

        int time = 0;
        while (time < S && queue.size() > 1) { // 시간이 `S`보다 작거나 큐가 비었을 경우 종료
            Virus virus = queue.poll();
            if (virus.id == -1) {
                time++;
                queue.offer(virus);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int newY = virus.y + dy[i];
                int newX = virus.x + dx[i];

                if (newY < 1 || newY > N || newX < 1 || newX > N || area[newY][newX] != 0) {
                    continue;
                }

                area[newY][newX] = virus.id;
                queue.offer(new Virus(virus.id, newY, newX));
            }
        }

        answer = area[X][Y];
    }

    private static class Virus implements Comparable<Virus> {
        int id;
        int y;
        int x;

        public Virus(int id, int r, int c) {
            this.id = id;
            y = r;
            x = c;
        }

        @Override
        public int compareTo(Virus other) {
            return Integer.compare(id, other.id);
        }
    }
}
