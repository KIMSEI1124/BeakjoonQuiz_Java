import java.io.*;
import java.util.*;

public class Q11660 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // Input
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1] + num - arr[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        // Solve
        while (M > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            ans.append(arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1]).append("\n");
            M--;
        }
        // Output
        System.out.println(ans);
    }
}