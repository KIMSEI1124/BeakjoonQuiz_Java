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
        if (N == 0) { // 수정

        }
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        while (M > 0) {
            st = new StringTokenizer(br.readLine());
            int start_node = Integer.parseInt(st.nextToken());
            int end_node = Integer.parseInt(st.nextToken());
            input(start_node, end_node, V);
            M--;
        }

        // solve
        visited = new boolean[1001];
        DFS(V);
        ans.append("\n");

        visited = new boolean[1001];
        BFS(V);

        // output
        System.out.println(ans);
    }

    static public void BFS(int V) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list;
        queue.add(V);
        visited[V] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans.append(node).append(" ");
            list = map.get(node);
            for (Integer index : list) {
                if (!visited[index]) {
                    queue.add(index);
                    visited[index] = true;
                }
            }
        }
    }

    static public void DFS(int V) {
        ans.append(V).append(" ");
        List<Integer> list = map.get(V);
        Collections.sort(list);
        visited[V] = true;
        for (Integer index : list) {
            if (!visited[index]) {
                DFS(index);
            }
        }
    }

    static public void input(int start_node, int end_node, int V) {
        List<Integer> list;
        // 양방향 삽압
        if (!map.containsKey(V)) {
            list = new ArrayList<>();
            map.put(V, list);
        }
        if (!map.containsKey(start_node)) { // 없을경우
            list = new ArrayList<>(); // 리스트 생성후
            list.add(end_node); // 노드 추가
            map.put(start_node, list); // HashMap에 저장
        } else { // 존재할 경우
            list = map.get(start_node); // 리스트 불러와서
            list.add(end_node); // 리스트에 추가
            map.replace(start_node, list); // HashMap에 저장
        }
        if (!map.containsKey(end_node)) {
            list = new ArrayList<>();
            list.add(start_node);
            map.put(end_node, list);
        } else {
            list = map.get(end_node);
            list.add(start_node);
            map.replace(end_node, list);
        }
    }
}