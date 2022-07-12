import java.io.*;
import java.util.*;

public class Q1325 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static int N, M, count, max_hacking = 0;
    static boolean[] visited;
    static List<List<Integer>> CR = new ArrayList<>(); // 컴퓨터 관계도
    static int[] hacking_count;

    public static void main(String[] args) throws IOException {
        // input

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 컴퓨터의 개수
        M = Integer.parseInt(st.nextToken()); // 컴퓨터의 관계의 수
        hacking_count = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            CR.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            CR.get(B).add(A);
        }

        // solve
        for (int i = 1; i <= N; i++) {
            count = 0; // 해킹된 컴퓨터의 개수
            visited = new boolean[N + 1]; // 해킹 여부 초기화
            dfs(i);
            hacking_count[i] = count;
            max_hacking = Math.max(max_hacking, count);
        }

        for (int i = 1; i <= N; i++) {
            if (hacking_count[i] == max_hacking) {
                ans.append(i + "\n");
            }
        }

        // output
        System.out.println(ans);
    }

    public static void dfs(int id) {
        if (visited[id]) {
            return;
        }
        visited[id] = true;
        count++;
        for (Integer new_id : CR.get(id)) {
            dfs(new_id);
        }
    }
}