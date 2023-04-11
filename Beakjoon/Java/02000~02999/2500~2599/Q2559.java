import java.io.*;
import java.util.*;

public class Q2559 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[N]; // 10
        int[] arr2 = new int[N - K + 1]; // 10 - 5 + 1 = 6
        st = new StringTokenizer(br.readLine());
        // solve
        int j = 1 - K; // arr2 포인터
        int max = 0;
        for (int i = 0; i < arr1.length; i++, j++) { // arr1 포인터
            arr1[i] = Integer.parseInt(st.nextToken());
            if (j > 0) { // j가 0이 아닐때
                arr2[j] = arr2[j - 1] + arr1[i] - arr1[i - K];
                max = Math.max(max, arr2[j]);
            } else if (j == 0) { // j가 0일때
                for (int k = 0; k < K; k++) {
                    arr2[0] += arr1[k];
                    max = arr2[0];
                }
            }
        }
        // output
        System.out.println(max);
    }
}