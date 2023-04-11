import java.io.*;
import java.util.*;

public class Q11003 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static int N, L;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        // solve
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
            if (queue.size() > L) {
                queue.poll();
            }
            ans.append(Collections.min(queue) + " ");
        }

        // output
        System.out.println(ans);
    }
}