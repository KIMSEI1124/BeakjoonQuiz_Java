import java.io.*;
import java.util.*;

public class Q1927 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // solve
        while (N > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty()) {
                    ans.append("0\n");
                } else {
                    ans.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(x);
            }
            N--;
        }
        // output
        System.out.println(ans);
    }
}