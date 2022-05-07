import java.io.*;
import java.util.*;

public class Q17298 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        br.close();
        // int[] arr = new int[N];
        Stack<Integer> stack = new Stack<>();
        // solve
        int start_num = Integer.parseInt(st.nextToken());
        stack.push(start_num);
        int high = start_num;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            System.out.println(stack);
            stack = check(stack, num);
        }
        ans.append("-1");
        // output
        System.out.println(ans);
    }

    public static Stack<Integer> check(Stack<Integer> stack, int num) {
        if (stack.peek() < num) {
            ans.append(num).append(" ");
            if (stack.isEmpty()) {
                stack.push(num);
                return stack;
            }
            stack.pop();
            return stack = check(stack, num);
        } else {
            stack.push(num);
            return stack;
        }
    }
}