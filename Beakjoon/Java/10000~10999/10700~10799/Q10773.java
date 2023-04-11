import java.io.*;
import java.util.*;

public class Q10773 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        while (K-- > 0) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                stack.pop();
                continue;
            }
            stack.push(number);
        }
        int sum = stack.stream().mapToInt(n -> n).sum();
        System.out.println(sum);
    }
}