import java.io.*;
import java.util.*;

public class Q1874 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int n;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
    }

    private static void solve() throws IOException {
        Stack<Integer> stack = new Stack<>();
        int number = 1;
        while (n-- > 0) {
            int targetNumber = Integer.parseInt(br.readLine());
            if (stack.isEmpty()) {
                add(stack, number++);
            }
            while (targetNumber > stack.peek()) {
                add(stack, number++);
            }
            if (stack.peek() == targetNumber) {
                pop(stack);
                continue;
            }
            if (stack.peek() > targetNumber) {
                answer = new StringBuilder("NO");
                return;
            }
        }
    }

    private static void add(Stack<Integer> stack, int number) {
        stack.add(number);
        answer.append("+").append("\n");
    }

    private static void pop(Stack<Integer> stack) {
        stack.pop();
        answer.append("-").append("\n");
    }
}