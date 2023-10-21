import java.io.*;

public class Q5554 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        arr = new int[5];
        for (int i = 1; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void solve() {
        int time = 0;
        for (int i = 1; i < 5; i++) {
            time += arr[i];
        }

        answer.append(time / 60).append("\n").append(time % 60);
    }
}