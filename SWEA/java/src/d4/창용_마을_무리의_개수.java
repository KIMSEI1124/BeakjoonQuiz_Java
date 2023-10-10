package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 창용_마을_무리의_개수 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();

    private static int t;

    private static int n, m;
    private static int result;

    private static List<List<Integer>> people;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            input();
            solve();
            answer.append("#").append(i).append(" ").append(result).append("\n");
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        people = new ArrayList<>();
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            people.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            people.get(a).add(b);
            people.get(b).add(a);
        }
    }

    private static void solve() {
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                result++;
            }
        }
    }

    private static void dfs(int id) {
        visited[id] = true;
        List<Integer> relation = people.get(id);

        for (int other : relation) {
            if (visited[other]) {
                continue;
            }
            dfs(other);
        }
    }
}
