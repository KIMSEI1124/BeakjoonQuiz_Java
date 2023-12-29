import java.io.*;

public class Q2754 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static double answer = 0.0;

    private static String input;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        input = br.readLine();
    }

    private static void solve() {
        char[] arr = input.toCharArray();
        if (arr[0] == 'A') {
            answer = 4.0;
        }
        if (arr[0] == 'B') {
            answer = 3.0;
        }
        if (arr[0] == 'C') {
            answer = 2.0;
        }
        if (arr[0] == 'D') {
            answer = 1.0;
        }
        if (answer == 0.0) {
            return;
        }
        if (arr[1] == '+') {
            answer += 0.3;
        }
        if (arr[1] == '-') {
            answer -= 0.3;
        }
    }
}