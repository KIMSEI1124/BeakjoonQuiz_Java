import java.io.*;

public class Q1075 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    private static int n;
    private static int f;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        f = Integer.parseInt(br.readLine());
    }

    private static void solve() {
        for (int i = 0; i < 100; i++) {
            int temp = ((n / 100) * 100) + i;
            if (temp % f == 0) {
                answer.append(String.format("%02d", i));
                return;
            }
        }
    }
}