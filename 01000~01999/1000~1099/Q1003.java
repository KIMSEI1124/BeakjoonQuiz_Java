import java.io.*;
import java.util.*;

public class Q1003 {    // 시간 초과 배열을 생성하여 처리하기.
    static Scanner sc = new Scanner(System.in);
    static int zeroCount;
    static int oneCount;

    public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            zeroCount = 0;
            oneCount = 0;
            fibonacci(N);
            sb.append(zeroCount + " " + oneCount + "\n");
            T--;
        }
        System.out.println(sb);
    }

    public static void fibonacci(int N) {
        if (N == 0) {
            zeroCount++;
        } else if (N == 1) {
            oneCount++;
        } else {
            fibonacci(N - 1);
            fibonacci(N - 2);
        }
    }
}