import java.io.*;

public class Q18406 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    private static String N;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        N = br.readLine();
    }

    private static void solve() {
        int head = 0;
        for (char c : N.substring(0, N.length() / 2).toCharArray()) {
            head += Character.getNumericValue(c);
        }

        for (char c : N.substring(N.length() / 2).toCharArray()) {
            head -= Character.getNumericValue(c);
        }

        if (head == 0) {
            answer.append("LUCKY");
            return;
        }
        answer.append("READY");
    }
}