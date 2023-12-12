import java.io.*;
import java.util.*;

public class Q30822 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer = Integer.MAX_VALUE;

    private static int n;
    private static String s;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        s = br.readLine();
    }

    private static void solve() {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        char[] array = { 'u', 'o', 's', 'p', 'c' };
        for (char c : array) {
            answer = Math.min(answer, map.getOrDefault(c, 0));
        }
    }
}