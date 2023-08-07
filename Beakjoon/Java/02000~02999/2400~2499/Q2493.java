import java.io.*;
import java.util.*;

public class Q2493 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();

    private static int n; // 탑의 개수
    private static int[] tops; // 탑의 높이
    private static Deque<Integer> list = new ArrayDeque<>(); // 수신 받을 탑의 리스트

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        tops = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solve() {
        answer.append("0 ");
        list.add(1);
        for (int i = 2; i <= n; i++) {
            int top = tops[i];
            while (!list.isEmpty() && top >= tops[list.peekLast()]) {
                list.pollLast();
            }
            if (list.isEmpty()) {
                answer.append("0 ");
            } else {
                answer.append(list.peekLast()).append(" ");
            }
            list.add(i);
        }
    }
}