import java.io.*;

public class Q4458 {
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

    private static void solve() throws IOException {
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            answer.append(s.substring(0, 1).toUpperCase()).append(s.substring(1)).append("\n");
        }
    }
}