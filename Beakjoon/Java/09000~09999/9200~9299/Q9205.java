import java.io.*;
import java.util.*;

public class Q9205 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static int T, store;
    static int[][] area;
    static boolean[] vistied;

    public static void main(String[] args) throws IOException {
        // input
        T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        while (T > 0) {
            store = Integer.parseInt(br.readLine()); // 편의점의 개수
            area = new int[store + 2][2];
            vistied = new boolean[store + 2][2];
            for (int i = 0; i < store + 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; j++) {
                    area[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // solve
            if (bfs(0)) {
                ans.append("happy\n");
            } else {
                ans.append("sad\n");
            }
        }

        // output
        System.out.println(ans);
    }

    public static boolean bfs(int id) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        int node = 0;
        while (!queue.isEmpty()) {
            if (node == store + 1) {    // 도달하면
                return true;
            }
        }
        return false;
    }
}