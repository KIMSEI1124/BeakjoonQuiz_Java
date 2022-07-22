import java.io.*;
import java.util.*;

public class Q12851 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K, count = 0;
    static int ans = 0;
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 시작 위치
        K = Integer.parseInt(st.nextToken()); // 도착 위치

        // solve
        queue.add(N);
        visited[N] = true;
        int queue_size;
        int id;
        boolean run = true;
        while (run) {
            ans++;
            queue_size = queue.size();
            while (queue_size > 0) {
                id = queue.poll();
                if (id == K) {
                    run = false;
                    ans--;
                    break;
                }
                queue_size--;
                bfs(id);
            }
        }

        // output
        System.out.println(ans + "\n" + count);
    }

    static char[] d = { '+', '-', '*' };

    public static void bfs(int id) {
        for (int i = 0; i < 3; i++) {
            calc(d[i], id);
        }
    }

    public static void calc(char op, int id) {
        if (op == '+') { // 1 더하기
            id++;
        } else if (op == '-') { // 1 빼기
            id--;
        } else { // 2 곱하기
            id *= 2;
        }
        if (id == K) {
            count++;
        }
        if (id < 0 || id > 100000 || visited[id]) {
            return;
        }
        visited[id] = true;
        queue.add(id);
    }
}