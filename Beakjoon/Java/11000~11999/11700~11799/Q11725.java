import java.io.*;
import java.util.*;

public class Q11725 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    private static int n; // 노드의 개수
    private static Map<Integer, Set<Integer>> tree; // 트리
    private static int[] parents; // 부모 저장
    private static boolean[] visited; // 방문 여부

    public static void main(String[] args) throws IOException {
        input();
        solve();
        print();
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        parents = new int[n + 1];
        visited = new boolean[n + 1];

        tree = new HashMap<>();
        for (int i = 1; i < n; i++) {
            /* 트리 입력 */
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            /* 트리 연결 */
            Set<Integer> aEdge = tree.getOrDefault(a, new HashSet<>());
            aEdge.add(b);
            tree.put(a, aEdge);

            Set<Integer> bEdge = tree.getOrDefault(b, new HashSet<>());
            bEdge.add(a);
            tree.put(b, bEdge);
        }
    }

    private static void solve() {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);

        while (!deque.isEmpty()) {
            int node = deque.pollFirst();
            visited[node] = true; // 방문 여부 체크
            Set<Integer> edges = tree.get(node); // 간선 조회

            for (Integer edge : edges) {
                if (visited[edge]) {
                    continue;
                }
                parents[edge] = node;
                deque.addLast(edge);
            }
        }
    }

    private static void print() {
        for (int i = 2; i <= n; i++) {
            answer.append(parents[i]).append("\n");
        }

        System.out.println(answer);
    }
}