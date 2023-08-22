import java.io.*;
import java.util.*;

public class Q13023 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer;

    private static int n;
    private static int m;
    private static List<List<Integer>> related = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 사람의 수
        m = Integer.parseInt(st.nextToken()); // 친구 관계의 수

        for (int i = 0; i < n; i++) {
            related.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            /* 관계 추가 */
            related.get(a).add(b);
            related.get(b).add(a);
        }
    }

    private static void solve() {
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            if (dfs(i, 1)) {
                answer = 1;
                break;
            }
        }
    }

    private static boolean dfs(int id, int count) {
        if (count == 5) {
            return true;
        }

        for (int next : related.get(id)) {
            /* 방문 하지 않았을 경우 탐색 */
            if (visited[next]) {
                continue;
            }

            visited[next] = true;
            if (dfs(next, count + 1)) {
                return true;
            }
            visited[next] = false;
        }

        return false;
    }
}
