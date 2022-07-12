import java.io.*;
import java.util.*;

public class Q1715 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans = 0;
    static StringTokenizer st;
    static int N;

    public static void main(String[] args) throws IOException {
        // input
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (N > 0) {
            pq.add(Integer.parseInt(br.readLine()));
            N--;
        }

        // solve
        while (pq.size() != 1) {
            pq.add(pq.poll() + pq.poll());
            ans += pq.peek();
            System.out.println(ans);
        }

        // output
    }
}