import java.io.*;
import java.util.*;

public class Q28353 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer = 0;

    private static int N;
    private static int K;

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
    }

    private static void solve() {
        Collections.sort(list);

        int head = 0;
        int tail = list.size() - 1;
        while (tail > head) {
            int weight = list.get(head) + list.get(tail);
            if (weight <= K) {
                answer++;
                head++;
            }
            tail--;
        }
    }
}