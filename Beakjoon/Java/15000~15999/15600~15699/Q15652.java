import java.io.*;
import java.util.*;

public class Q15652 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    private static int n, m;
    private static int[] temp;

    public static void main(String[] args) throws IOException {
        input();
        solve(0, 1);
        System.out.println(answer);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        temp = new int[m];
    }

    private static void solve(int count, int start) {
        if (count == m) {
            appendAnswer();
            return;
        }

        for (int i = start; i <= n; i++) {
            temp[count] = i;
            solve(count + 1, i);
        }
    }

    private static void appendAnswer() {
        for (int i = 0; i < m; i++) {
            answer.append(temp[i]).append(" ");
        }
        answer.append("\n");
    }
}