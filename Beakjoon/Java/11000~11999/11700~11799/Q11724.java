import java.io.*;
import java.util.*;

public class Q11724 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] visited; // 방문 확인 하는 배열
    static List<ArrayList<Integer>> graph = new ArrayList<>(); // 인접리스트로 구현
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // input
        int ans = 0;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        visited = new boolean[N + 1]; // 0은 없는 취급하기 false : 방문 X, true : 방문 O
        for (int i = 0; i <= N; i++) { // 0은 없는 정점 취급
            graph.add(new ArrayList<Integer>());
        }
        while (M > 0) {
            st = new StringTokenizer(br.readLine());
            int start_node = Integer.parseInt(st.nextToken());
            int end_node = Integer.parseInt(st.nextToken());
            // 양방향 이므로 두개를 포함시켜줌
            graph.get(start_node).add(end_node);
            graph.get(end_node).add(start_node);
            M--;
        }
        br.close();
        // solve
        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i);
                ans++;
            }
        }
        // output
        System.out.println(ans);
    }

    public static void dfs(int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int j : graph.get(i)) {
            if (visited[j] == false) {
                dfs(j);
            }
        }
    }
}