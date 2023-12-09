import java.io.*;

public class Q1292 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int start;
    private static int end;
    private static int answer;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        String input = br.readLine();
        start = Integer.parseInt(input.split(" ")[0]);
        end = Integer.parseInt(input.split(" ")[1]);
    }

    private static void solve() {
        int count = 1;
        for (int i = 1; i <= 1_000; i++) {
            for (int j = 0; j < i; j++) {
                if (count >= start) {
                    answer += i;
                }
                if (count == end) {
                    return;
                }
                count++;
            }
        }
    }
}