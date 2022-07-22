import java.io.*;
import java.util.*;

public class Q15650 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 1 ~ N까지 자연수
        M = Integer.parseInt(st.nextToken()); // M개를 고른 수열

        // solve
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i, 0, "");
        }

        // output
        System.out.println(ans);
    }

    public static void dfs(int id, int depth, String str) {
        if (visited[id] || depth > M) {
            return;
        }
        visited[id] = true;
        str += id + " ";
        depth++;
        if (depth == M) {
            ans.append(str + "\n");
        }
        for (int i = id + 1; i <= N; i++) { // 15649) i = 1, 15650) i = id+1
            dfs(i, depth, str);
        }
        visited[id] = false;
    }
}