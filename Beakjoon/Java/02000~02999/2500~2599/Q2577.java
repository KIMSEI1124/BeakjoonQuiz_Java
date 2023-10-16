import java.io.*;
import java.util.*;

public class Q2577 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    private static int a, b, c;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());
    }

    private static void solve() {
        int[] count = new int[10];
        long number = a * b * c;
        String strNumber = String.valueOf(number);
        for (int i = 0; i < strNumber.length(); i++) {
            char c = strNumber.charAt(i);
            int key = Integer.parseInt(String.valueOf(c));
            count[key]++;
        }

        for (int i = 0; i < count.length; i++) {
            answer.append(count[i]).append("\n");
        }
    }
}