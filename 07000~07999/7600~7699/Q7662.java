import java.io.*;
import java.util.*;

public class Q7662 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    private static final String INPUT = "I";
    private static final String DELETE = "D";
    private static final int MAX_VALUE_DELETE = 1;
    private static final int MIN_VALUE_DELETE = -1;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            answer.append(getAnswer()).append("\n");
        }
        System.out.println(answer);
    }

    private static String getAnswer() throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> reversQueue = new PriorityQueue<>(Collections.reverseOrder());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String code = st.nextToken();
            int number = Integer.parseInt(st.nextToken());
            if (code.equals(INPUT)) {
                queue.offer(number);
                reversQueue.offer(number);
                // continue;
            }
            if (code.equals(DELETE) && !queue.isEmpty()) {
                if (number == MAX_VALUE_DELETE) {
                    queue.poll();
                    reversQueue.remove();
                }
                if (number == MIN_VALUE_DELETE) {
                    queue.remove();
                    reversQueue.poll();
                }
            }
            System.out.println(reversQueue);
        }
        if (queue.isEmpty()) {
            return "EMPTY";
        }
        int[] temp = queue.stream().mapToInt(v -> v).toArray();
        return temp[temp.length - 1] + " " + temp[0];
    }
}