import java.io.*;
import java.util.*;

public class Q1240 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static List<List<Node<Integer, Integer>>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // Node
        M = Integer.parseInt(st.nextToken()); // Edge
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        Node<Integer, Integer> node_one;
        Node<Integer, Integer> node_two;
        for (int i = 0; i < N - 1; i++) { // 그래프 입력
            st = new StringTokenizer(br.readLine());
            node_one = new Node<>();
            node_two = new Node<>();

            int node_one_id = Integer.parseInt(st.nextToken());
            int node_two_id = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            node_one.set_node(node_two_id, cost);
            node_two.set_node(node_one_id, cost);

            graph.get(node_one_id).add(node_one);
            graph.get(node_two_id).add(node_two);
        }
        // solve
        int start_node;
        int target_node;
        int cost;
        while (M > 0) {
            visited = new boolean[N + 1];
            st = new StringTokenizer(br.readLine());
            start_node = Integer.parseInt(st.nextToken());
            target_node = Integer.parseInt(st.nextToken());
            cost = 0;
            bfs(start_node, target_node, cost);
            M--;
        }

        // output
        System.out.println(ans);
    }

    public static void bfs(int node, int target, int cost) {
        if (node == target) { // 원하는 노드에 도착
            ans.append(cost + "\n");
            return;
        }
        if (visited[node]) { // 방문한적이 있으면
            return;
        }
        visited[node] = true;
        Node<Integer, Integer> new_node;
        for (int i = 0; i < graph.get(node).size(); i++) {
            new_node = graph.get(node).get(i);
            bfs(new_node.get_id(), target, cost + new_node.get_cost());
        }
    }
}

class Node<id, cost> {
    private int id;
    private int cost;

    public void set_node(int id, int cost) {
        this.id = id;
        this.cost = cost;
    }

    public int get_id() {
        return this.id;
    }

    public int get_cost() {
        return this.cost;
    }
}