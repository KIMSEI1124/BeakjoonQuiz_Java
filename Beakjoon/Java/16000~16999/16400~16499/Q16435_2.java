import java.io.*;
import java.util.*;

public class Q16435_2 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer;
    private static StringTokenizer st;

    private static int n, l; // 과일의 개수, 초기 길이

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
    }

    private static void solve() throws IOException {
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // 오름차순
        st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            queue.add(Integer.parseInt(st.nextToken()));
            while (!queue.isEmpty() && l >= queue.peek()) { // 비어있지 않고, 뱀이 과일을 먹을 수 있을 때
                queue.poll();
                l++; // 뱀의 크기 증가
            }
        }
        answer = l;
    }
}