import java.io.*;
import java.util.*;

public class Q11004 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 배열의 크기
        int M = Integer.parseInt(st.nextToken()); // target_point
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        br.close();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // solve
        Arrays.sort(arr);
        // output
        System.out.println(arr[M - 1]);
    }
}