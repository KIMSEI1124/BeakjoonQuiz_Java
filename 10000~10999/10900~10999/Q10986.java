import java.io.*;
import java.util.*;

public class Q10986 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] ar1 = new int[N + 1];
        int[] ar2 = new int[M];
        int ans = 0;
        // solve
        for (int i = 1; i <= N; i++) {
            ar1[i] = Integer.parseInt(st.nextToken()) + ar1[i - 1];
            int num1 = ar1[i] % M;
            ar2[num1]++;
        }
        for (int i = 1; i < M; i++) {

        }
        // output
        System.out.println(ans);
    }
}