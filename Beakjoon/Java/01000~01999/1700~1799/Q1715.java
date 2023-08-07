import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q1715 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static PriorityQueue<Integer> queue;
    private static int answer;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        queue = initQueue();
    }

    private static void solve() throws IOException {
        while (n-- > 0) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        while (queue.size() != 1) {
            int temp = queue.poll() + queue.poll();
            answer += temp;
            queue.add(temp);
        }
    }

    private static PriorityQueue<Integer> initQueue() {
        return new PriorityQueue<>((o1, o2) -> {
            return o1 - o2;
        });
    }

}
