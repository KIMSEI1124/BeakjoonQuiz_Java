import java.io.*;
import java.util.*;

public class Q15649 {
    public static void main(String[] args) throws IOException {
        // settings
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // input
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 1; i <= N; i++) {
            arr[i - 1] = i;
        }

        // 반복 횟수 구하기
        int run = 1;
        for (int i = N; i > N - M; i--) {
            run *= i;
        }

        // solve
        while (run > 0) {
            
            run -= 1;
        }
    }
}