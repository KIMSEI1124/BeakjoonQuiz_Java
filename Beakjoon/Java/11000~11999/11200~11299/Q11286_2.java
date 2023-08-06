import java.io.*;
import java.util.*;

public class Q11286_2 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    private static final int POLL = 0; // 출력 트리거

    private static int N;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    private static void solve() throws IOException {
        PriorityQueue<Integer> queue = initQueue();
        while (N-- > 0) {
            int temp = Integer.parseInt(br.readLine());
            if (temp == POLL) {
                if (queue.isEmpty()) {
                    answer.append("0\n");
                } else {
                    answer.append(queue.poll()).append("\n");
                }
                continue;
            }
            queue.add(temp);
        }
    }

    private static PriorityQueue<Integer> initQueue() {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int a = Math.abs(o1);
            int b = Math.abs(o2);
            if (a == b) {
                return o1 > o2 ? 1 : -1;
            } else {
                return a - b;
            }
        });
        return queue;
    }
}