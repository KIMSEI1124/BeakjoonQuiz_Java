import java.io.*;
import java.util.*;

public class Q1167 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    static int V; // 트리의 정점의 개수
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>(); // 좌표값만 저장
    static int[] length;
    static List<List<Map<Integer, Integer>>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // input
        V = Integer.parseInt(br.readLine());
        visited = new boolean[V + 1];
        length = new int[V + 1];

        for (int i = 0; i < V; i++) {
            tree.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken()); // 정점의 Id
            while (st.hasMoreTokens()) {
                int node = Integer.parseInt(st.nextToken());
                if (node != -1) {
                    int edge = Integer.parseInt(st.nextToken());
                    Map<Integer, Integer> node_map = new HashMap<>();
                    node_map.put(node, edge); // 정점, 간선의 거리
                    tree.get(id - 1).add(node_map);
                }
            }
        }

        // solve
        queue.add(1);
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            visited[pos] = true; // 방문확인
            for (Map<Integer, Integer> node : tree.get(pos)) {
                // int node_pos = node.get(key)
                // HashMap으로 하니 Key값을 알수가 없다.
                // id도 따로 저장을 해둬야 하는가?... -- 메모리 증가
                // 아니면 다른 방식이 있을까?
                // 객체를 만들어 두고 for문을 돌린다?... 
            }

        }
        // output
        System.out.println(ans);
    }
}