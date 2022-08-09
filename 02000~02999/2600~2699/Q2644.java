import java.io.*;
import java.util.*;

public class Q2644 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    static int N, start, target, m;
    static boolean[] vistied;
    static List<List<Integer>> family;

    public static void main(String[] args) throws IOException {
        // input
        N = Integer.parseInt(br.readLine()); // 전체 사람의 수

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()); // 촌수를 계산하는 사람1
        target = Integer.parseInt(st.nextToken()); // 촌수를 계산하는 사람2

        m = Integer.parseInt(br.readLine()); // 부모 자식들간의 관계의 개수
        family = new ArrayList<>();
        vistied = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            family.add(new ArrayList<>());
        }

        int f1, f2;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            f1 = Integer.parseInt(st.nextToken());
            f2 = Integer.parseInt(st.nextToken());
            family.get(f1).add(f2);
            family.get(f2).add(f1);
        }

        // solve
        dfs(start, target, 0);
        bfs(start, target, 0);

        // output
        if (ans.length() == 0) {
            System.out.println("-1");
        } else {
            System.out.println(ans);
        }
    }

    public static void dfs(int start, int target, int depth) {
        if (vistied[start] || vistied[target]) {
            return;
        }
        vistied[start] = true;

        if (vistied[target]) {
            ans.append(depth);
        }
        depth++;

        List<Integer> list = family.get(start);
        for (Integer f : list) {
            dfs(f, target, depth);
        }
    }

    public static void bfs(int start, int target, int depth) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            int queue_size = queue.size();
            int f;
            for(int i = 0; i < queue_size; i++) {
                f = queue.poll();
                if(vistied[f] || vistied[target]) {
                    continue;
                }
                vistied[f] = true;

                if(vistied[target]) {
                    ans.append(depth);
                }

                List<Integer> list = family.get(f);
                for (Integer l : list) {
                    queue.add(l);
                }
            }
            depth++;
        }
    }
}