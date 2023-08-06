import java.io.*;
import java.util.*;

public class Q1182 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int answer;

    private static int N, S;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        input();
        solve(0, 0, 0);
        System.out.println(answer);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solve(int idx, int length, int sum) {
        if (idx + length >= N) {
            return;
        }

        sum += array[idx + length];
        solve(idx, length + 1, sum);

        if (S == sum) {
            answer++;
        }

        sum -= array[idx + length];
        solve(idx + 1, length, sum);
    }
}