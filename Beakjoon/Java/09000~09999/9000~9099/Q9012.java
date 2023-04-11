import java.io.*;
import java.util.*;

public class Q9012 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            char[] arr = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            if (arr.length % 2 != 0) {
                sb.append("NO\n");
            } else {
                for (int i = 0; i < arr.length; i++) {
                    char c = arr[i];
                    if (stack.size() >= 1) {
                        if (c == ')' && stack.peek() == '(') {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                    } else {
                        stack.push(c);
                    }
                }
                if (stack.size() == 0) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
            T--;
        }
        System.out.println(sb);
    }
}