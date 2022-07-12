import java.io.*;
import java.util.*;

public class Q18352 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static int N, M, K, X;
    static List<List<Integer>> citys = new ArrayList<>();
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    static List<Integer> target_citys = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        M = Integer.parseInt(st.nextToken()); // 도로의 개수
        K = Integer.parseInt(st.nextToken()); // 거리 정보
        X = Integer.parseInt(st.nextToken()); // 출발 도시
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) { // 인접 리스트
            citys.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) { // 단방향 도로
            st = new StringTokenizer(br.readLine());
            int start_ctiy = Integer.parseInt(st.nextToken());
            int target_city = Integer.parseInt(st.nextToken());
            citys.get(start_ctiy).add(target_city);
        }
        // solve
        queue.add(X);
        visited[X] = true;
        for (int i = 1; i <= K; i++) {
            bfs(i);
        }

        // output
        if (target_citys.size() == 0) {
            ans.append("-1");
        } else {
            Collections.sort(target_citys);
            for (Integer id : target_citys) {
                ans.append(id + "\n");
            }
        }
        System.out.println(ans);
    }

    public static void bfs(int length) {
        int queue_size = queue.size();
        while (queue_size > 0) {
            int city_id = queue.poll();
            for (Integer id : citys.get(city_id)) {
                if (visited[id]) {
                    continue;
                }
                if (length == K) {
                    target_citys.add(id);
                } else {
                    visited[id] = true;
                }
                queue.add(id);
            }

            queue_size--;
        }
    }
}