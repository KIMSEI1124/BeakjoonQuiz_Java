import java.io.*;

public class Q25314 {
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

    private static void solve() {
        for (int i = 0; i < n / 4; i++) {
            answer.append("long").append(" ");
        }
        answer.append("int");
    }
}