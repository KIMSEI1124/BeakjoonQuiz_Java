package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1967 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int answer;
    private static Map<Integer, Map<Integer, Integer>> tree;    // Key : Node, Value : ( Key : Edge, Value : Weight )
    private static boolean[] nodeVisited;
    private static boolean[] weightVisited;
    private static int n;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        nodeVisited = new boolean[n + 1];
        tree = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            Map<Integer, Integer> aEdgeMap = tree.getOrDefault(a, new HashMap<>());
            aEdgeMap.put(b, weight);
            tree.put(a, aEdgeMap);

            Map<Integer, Integer> bEdgeMap = tree.getOrDefault(b, new HashMap<>());
            bEdgeMap.put(a, weight);
            tree.put(b, bEdgeMap);
        }
    }

    private static void solve() {
        nodeDfs(1);
    }

    private static void nodeDfs(int node) {
        if (nodeVisited[node]) {    // 방문했으면 종료
            return;
        }

        nodeVisited[node] = true;
        Map<Integer, Integer> nodeEdges = tree.get(node);   // key: edge, value: weight

        weightVisited = new boolean[n + 1];
        weightDfs(node, 0);

        for (Integer edge : nodeEdges.keySet()) {
            nodeDfs(edge);
        }
    }

    private static void weightDfs(int node, int weight) {
        if (weightVisited[node]) {
            return;
        }

        weightVisited[node] = true;
        Map<Integer, Integer> nodeEdges = tree.get(node);   // key: edge, value: weight
        answer = Math.max(answer, weight);

        for (Integer edge : nodeEdges.keySet()) {
            Integer edgeWeight = tree.get(node).get(edge);
            weightDfs(edge, weight + edgeWeight);
        }
    }
}
