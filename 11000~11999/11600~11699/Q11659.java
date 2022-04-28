import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        int sum = 0;
        for (int i = 0; i <= N; i++) {
            if (i == 0) {
                st = new StringTokenizer(br.readLine());
            } else {
                sum += Integer.parseInt(st.nextToken());
            }
            arr[i] = sum;
        }
        while (M > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int End = Integer.parseInt(st.nextToken());
            sb.append(arr[End] - arr[start]).append("\n");
            M--;
        }
        System.out.println(sb);
    }
}