import java.io.*;
import java.util.*;

public class Q18258 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String opCode = st.nextToken();
            if (opCode.equals("push")) {
                int number = Integer.parseInt(st.nextToken());
                push(number, deque);
                continue;
            }
            if (opCode.equals("pop")) {
                answer.append(pop(deque));
            }
            if (opCode.equals("size")) {
                answer.append(size(deque));
            }
            if (opCode.equals("empty")) {
                answer.append(empty(deque));
            }
            if (opCode.equals("front")) {
                answer.append(front(deque));
            }
            if (opCode.equals("back")) {
                answer.append(back(deque));
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }

    private static void push(int x, Deque<Integer> deque) {
        deque.add(x);
    }

    private static int pop(Deque<Integer> deque) {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.pop();
    }

    private static int size(Deque<Integer> deque) {
        return deque.size();
    }

    private static int empty(Deque<Integer> deque) {
        if (deque.isEmpty()) {
            return 1;
        }
        return 0;
    }

    private static int front(Deque<Integer> deque) {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    private static int back(Deque<Integer> deque) {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekLast();
    }
}