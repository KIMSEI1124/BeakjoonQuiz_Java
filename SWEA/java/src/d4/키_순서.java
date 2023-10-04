package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 키_순서 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();

    private static int T;
    private static int N, M;
    private static List<List<Integer>> tallEdges;
    private static List<List<Integer>> longEdges;
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            input();
            answer.append("#").append(i).append(" ").append(solve()).append("\n");
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        longEdges = new ArrayList<>();
        tallEdges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            longEdges.add(new ArrayList<>());
            tallEdges.add(new ArrayList<>());
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            tallEdges.get(to).add(from);
            longEdges.get(from).add(to);
        }
    }

    private static int solve() {
        int totalCount = 0;
        for (int i = 1; i <= N; i++) {
            count = 1;
            visited = new boolean[N + 1];
            searchTall(i);
            searchLong(i);
            if (N == count) {
                totalCount++;
            }
        }
        return totalCount;
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
