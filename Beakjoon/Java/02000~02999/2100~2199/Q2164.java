import java.io.*;
import java.util.*;

public class Q2164 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // input
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        // solve
        int run = 0;
        while (queue.size() > 1) {
            if (run % 2 == 0) {
                queue.poll();
            } else {
                queue.add(queue.poll());
            }
            run++;
        }
        // output
        System.out.println(queue.peek());
    }
}