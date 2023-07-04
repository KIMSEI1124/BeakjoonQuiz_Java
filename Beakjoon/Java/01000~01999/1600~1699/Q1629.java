import java.io.*;
import java.util.*;

public class Q1629 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        long answer = getAnswer(A, B, C);
        System.out.println(answer);
    }

    private static long getAnswer(int a, int b, int c) {
        /* 종료 조건 */
        if (b == 1) {
            return a % c;
        }

        long result = getAnswer(a, b / 2, c);
        result = (result * result) % c;

        /* 홀수일 때 한번 더 곱한다 */
        if (b % 2 == 1) {
            result = (result * a) % c;
        }

        return result;
    }
}