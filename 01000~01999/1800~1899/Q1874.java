import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1874 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int add = 1;
        while (N > 0) {
            int num = Integer.parseInt(br.readLine());
            while (true) {
                if (stack.contains(num)) {
                    if (stack.pop().intValue() == num) {
                        sb.append("-").append("\n");
                        break;
                    } else {
                        N = 0;
                        break;
                    }
                } else {
                    stack.add(add);
                    sb.append("+").append("\n");
                    add += 1;
                }
            }
            N--;
        }
        if (stack.size() == 0) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}