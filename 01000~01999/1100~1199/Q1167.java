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
    static List<List<Node_1167<Integer, Integer>>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // input
        V = Integer.parseInt(br.readLine());
        visited = new boolean[V + 1];
        length = new int[V + 1];

        Node_1167<Integer, Integer> node;
        tree.add(new ArrayList<>());
        for (int i = 1; i <= V; i++) {
            tree.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken()); // 정점의 Id
            while (st.hasMoreTokens()) {
                int target_id = Integer.parseInt(st.nextToken());
                node = new Node_1167<>();
                if (target_id != -1) {
                    node.set_node(target_id, Integer.parseInt(st.nextToken()));
                    tree.get(id).add(node);
                }
            }
        }

        // solve
        int len = 0;
        dfs(1, len);

        // output
        System.out.println(ans);
    }

    public static void dfs(int id, int len) {
        visited[id] = true;

        Node_1167<Integer, Integer> new_node;
        for (int i = 0; i < tree.get(id).size(); i++) {
            new_node = new Node_1167<>();
            if (!visited[new_node.get_id()]) {
                len += new_node.get_length();
                dfs(new_node.get_id(), len);
                System.out.println("id : \"" + new_node.get_id() + "\", len : \"" + new_node.get_length() + "\"");
            }
        }
    }
}

class Node_1167<id, length> {
    private int id;
    private int length;

    public void set_node(int id, int length) {
        this.id = id;
        this.length = length;
    }

    public int get_id() {
        return this.id;
    }

    public int get_length() {
        return this.length;
    }
}