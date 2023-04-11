import java.io.*;
import java.util.*;

public class Q2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int ans = 0;
    static boolean[] visited;
    static List<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        // input
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        graph = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start_node = Integer.parseInt(st.nextToken());
            int end_node = Integer.parseInt(st.nextToken());
            graph.get(start_node).add(end_node);
            graph.get(end_node).add(start_node);
        }
        // solve
        dfs(1);
        // output
        System.out.println(ans);
    }

    static public void dfs(int node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (Integer index : graph.get(node)) {
            if (visited[index] == false) {
                dfs(index);
                ans++;
            }
        }
    }
}