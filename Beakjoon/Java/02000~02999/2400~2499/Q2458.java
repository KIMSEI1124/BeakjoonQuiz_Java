import java.io.*;
import java.util.*;

public class Q2458 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer = 0;

    private static int N, M;
    private static List<List<Integer>> tallEdges;
    private static List<List<Integer>> longEdges;
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        longEdges = new ArrayList<>();
        tallEdges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            longEdges.add(new ArrayList<>());
            tallEdges.add(new ArrayList<>());
        }

        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            tallEdges.get(to).add(from);
            longEdges.get(from).add(to);
        }
    }

    private static void solve() {
        answer = 0;
        for (int i = 1; i <= N; i++) {
            count = 1;
            visited = new boolean[N + 1];
            searchTall(i);
            searchLong(i);
            if (N == count) {
                answer++;
            }
        }
    }

    private static void searchTall(int id) {
        for (int i : tallEdges.get(id)) {
            if (visited[i]) {
                continue;
            }
            count++;
            visited[i] = true;
            searchTall(i);
        }
    }

    private static void searchLong(int id) {
        for (int i : longEdges.get(id)) {
            if (visited[i]) {
                continue;
            }
            count++;
            visited[i] = true;
            searchLong(i);
        }
    }
}