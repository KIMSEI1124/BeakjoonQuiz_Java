import java.io.*;

public class Q14581 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    private static String fan = ":fan:";
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
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j && i == 1) {
                    answer.append(":")
                            .append(input)
                            .append(":");
                    continue;
                }
                answer.append(fan);
            }
            answer.append("\n");
        }
    }
}