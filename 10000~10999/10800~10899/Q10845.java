import java.io.*;
import java.util.*;

public class Q10845 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String code = st.nextToken();
            if (code.equals("push")) {
                deque.push(Integer.parseInt(st.nextToken()));
                continue;
            }
            if(code.equals("size")) {
                answer.append(deque.size()).append("\n");
                continue;
            }
            if(code.equals("empty")) {
                if(deque.isEmpty()) {
                    answer.append("1");
                } else {
                    answer.append("0");
                }
                answer.append("\n");
                continue;
            }
            if(deque.isEmpty()) {
                answer.append("-1");
            } else {
                if(code.equals("pop")) {
                    answer.append(deque.pollLast());
                }
                if(code.equals("front")) {
                    answer.append(deque.getLast());
                }
                if(code.equals("back")) {
                    answer.append(deque.getFirst());
                }
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}