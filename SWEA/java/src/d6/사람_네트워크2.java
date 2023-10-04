package d6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사람_네트워크2 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static int t;
    private static int result;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            input();
            solve(i);
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        result = 0;
    }

    private static void solve(int testCase) {


        /* 정답 추가 */
        answer.append("#").append(testCase).append(" ").append(result).append("\n");
    }
}
