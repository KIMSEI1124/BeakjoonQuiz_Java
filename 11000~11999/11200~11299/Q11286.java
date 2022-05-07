import java.io.*;
import java.util.*;

public class Q11286 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        int N = Integer.parseInt(br.readLine());
        // solve
        solve1(N);
        // output
        System.out.println(ans);
    }

    public static void solve1(int N) throws IOException {
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
    }

    public static void solve2(int N) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {   // compareTo 공부하기
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if (abs1 == abs2) { // 절대값이 같으면
                return o1 > o2 ? 1 : -1;    // 삼항연산자 
            } else {
                return abs1 - abs2;
            }
        });
        while (N > 0) {
            int input_num = Integer.parseInt(br.readLine());
            if (input_num == 0) {
                if (pq.isEmpty()) {
                    ans.append("0\n");
                } else {
                    ans.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(input_num);
            }
            System.out.println(pq);
            N--;
        }
    }
}