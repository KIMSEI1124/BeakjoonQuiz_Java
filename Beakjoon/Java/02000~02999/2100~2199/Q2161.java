import java.io.*;
import java.util.*;

public class Q2161 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    private static int N;
    private static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }
    }

    private static void solve() {
        int count = 1;
        while (!deque.isEmpty()) {
            int number = deque.poll();
            if (count++ % 2 == 0) {
                deque.offer(number);
                continue;
            }
            answer.append(number).append(" ");
        }
    }
}