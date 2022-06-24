import java.io.*;
import java.util.*;

public class Q13023 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    static HashMap<Integer, List<Integer>> map;
    static boolean check = false;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        visited = new boolean[N];
        int depth = 1;

        while (M > 0) {
            st = new StringTokenizer(br.readLine());
            int start_node = Integer.parseInt(st.nextToken());
            int end_node = Integer.parseInt(st.nextToken());
            input_map(start_node, end_node);
            M--;
        }
        // solve
        for (int i = 0; i < N; i++) {
            dfs(0, depth);
        }
        // output
        if (check) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    public static void dfs(int node, int depth) {
        if (check || depth >= 5) {
            check = true;
            return;
        }
        visited[node] = true;
        List<Integer> list = map.get(node);
        for (Integer index : list) {
            if (!visited[index]) {
                dfs(index, depth + 1);
            }
        }
        visited[node] = false;
    }

    public static void input_map(int start_node,
            int end_node) {
        if (!map.containsKey(start_node)) {
            List<Integer> list = new ArrayList<>();
            list.add(end_node);
            map.put(start_node, list);
        } else {
            List<Integer> list = map.get(start_node);
            list.add(end_node);
            map.replace(start_node, list);
        }
        if (!map.containsKey(end_node)) {
            List<Integer> list = new ArrayList<>();
            list.add(start_node);
            map.put(end_node, list);
        } else {
            List<Integer> list = map.get(end_node);
            list.add(start_node);
            map.replace(end_node, list);
        }
    }
}