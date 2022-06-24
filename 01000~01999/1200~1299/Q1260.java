import java.io.*;
import java.util.*;

public class Q1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static HashMap<Integer, List<Integer>> map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        while (M > 0) {
            st = new StringTokenizer(br.readLine());
            int start_node = Integer.parseInt(st.nextToken());
            int end_node = Integer.parseInt(st.nextToken());
            input(start_node, end_node);
            M--;
        }
        // solve
        DFS(N, V);
        BFS(N, V);
        // output
        System.out.println(ans);
    }

    static public void BFS(int N, int V) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list;

        visited = new boolean[1001];
        queue.add(V);
        visited[V] = true;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            ans.append(node).append(" ");
            list = map.get(node);
            Collections.sort(list);
            for (Integer index : list) {
                if(!visited[index]) {
                    queue.add(index);
                    visited[index] = true;
                }
            }
        }
    }

    static public void DFS(int N, int V) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list;

        visited = new boolean[1001];
        stack.add(V);
        visited[V] = true;
        while(!stack.isEmpty()) {
            int node = stack.pop();
            ans.append(node).append(" ");
            list = map.get(node);
            Collections.sort(list);
            for (Integer index : list) {
                if(!visited[index]) {
                    stack.add(index);
                    visited[index] = true;
                }
            }
        }
        ans.append("\n");
    }

    static public void input(int start_node, int end_node) {
        List<Integer> list;
        if (!map.containsKey(start_node)) {
            list = new ArrayList<>();
            list.add(end_node);
            map.put(start_node, list);
        } else {
            list = map.get(start_node);
            list.add(end_node);
            map.replace(start_node, list);
        }
        if (!map.containsKey(end_node)) {
            list = new ArrayList<>();
            list.add(start_node);
            map.put(end_node, list);
        } else {
            list = map.get(end_node);
            list.add(start_node);
            map.remove(end_node, list);
        }
    }
}