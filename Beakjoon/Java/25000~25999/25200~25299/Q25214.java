import java.io.*;
import java.util.*;

public class Q25214 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N + 1];
        int[] answer = new int[N + 1]; // 정답
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // solve

        // * A_i가 A_i-1 보다 작으면? answer[A_i-1]이 가장 큰 값
        for (int i = 1; i <= N; i++) {
            // 최소값 구하기
            if (min > Math.min(arr[i], min)) {
                min = arr[i];
            }
            // answer 구하기
            if (arr[i] - min < answer[i - 1]) {
                answer[i] = answer[i - 1];
            } else {
                answer[i] = arr[i] - min;
            }
            ans.append(answer[i] + " ");
        }

        // output
        System.out.println(ans);
    }
}