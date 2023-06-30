import java.io.*;
import java.util.*;

public class Q3986 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        String input;
        while (n-- > 0) {
            input = br.readLine();
            if (isGoodWord(input)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean isGoodWord(String word) {
        Deque<Character> deque = new ArrayDeque<>();

        for (Character c : word.toCharArray()) {
            if (!deque.isEmpty() && c == deque.peekLast()) {
                deque.pollLast();
                continue;
            }
            deque.addLast(c);
        }

        return deque.isEmpty();
    }
}