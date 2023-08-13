import java.io.*;
import java.util.*;

public class Q10811 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    private static int n, m;

    private static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            list.add(i);
        }
    }

    private static void solve() throws IOException {
        Deque<Integer> stack = new ArrayDeque<>();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int i = start; i <= end; i++) {
                stack.addLast(list.get(i));
            }

            while (!stack.isEmpty()) {
                for (int i = start; i <= end; i++) {
                    list.set(i, stack.pollLast());
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            answer.append(list.get(i)).append(" ");
        }
    }
}