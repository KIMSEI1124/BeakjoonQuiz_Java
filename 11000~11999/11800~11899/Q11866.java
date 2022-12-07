import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Q11866 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = getDeque(N);
        System.out.println(getResult(deque, K));
    }

    private static Deque<Integer> getDeque(int N) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        return deque;
    }

    private static String getResult(Deque<Integer> deque, int K) {
        List<Integer> list = new ArrayList<>(Collections.emptyList());
        int count = 1;
        while (!deque.isEmpty()) {
            int h = deque.pollFirst();
            if (count % K == 0) {
                list.add(h);
            }
            if (count % K != 0) {
                deque.add(h);
            }
            count++;
        }
        return list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "<", ">"));
    }
}