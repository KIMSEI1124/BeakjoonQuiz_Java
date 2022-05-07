import java.io.*;
import java.util.*;

public class Q11286 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(); // 양수
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder()); // 음수
        // solve
        // 절대값이 같으면 음수 -> 양수
        while (N > 0) {
            int input_num = Integer.parseInt(br.readLine());
            if (input_num == 0) {
                if (pq1.isEmpty() && pq2.isEmpty()) {
                    ans.append("0").append("\n");
                } else if (pq2.isEmpty()) {
                    ans.append(pq1.poll()).append("\n");
                } else if (pq1.isEmpty()) {
                    ans.append(pq2.poll()).append("\n");
                } else {
                    int num1 = pq1.peek();
                    int num2 = pq2.peek() * -1;
                    if (num1 >= num2) {
                        ans.append(pq2.poll()).append("\n");
                    } else {
                        ans.append(pq1.poll()).append("\n");
                    }
                }
            } else {
                if (input_num < 0) {
                    pq2.add(input_num);
                } else if (input_num > 0) {
                    pq1.add(input_num);
                }
            }
            N--;
        }
        // output
        System.out.println(ans);
    }
}