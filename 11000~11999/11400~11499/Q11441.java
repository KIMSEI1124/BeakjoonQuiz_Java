import java.io.*;
import java.util.*;

public class Q11441 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        // solve
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        while (M > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ans.append(arr[end] - arr[start - 1]).append("\n");
            M--;
        }
        // output
        System.out.println(ans);
    }
}