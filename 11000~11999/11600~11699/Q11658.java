import java.io.*;
import java.util.*;

public class Q11658 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr1 = new int[N + 1][N + 1]; // 원본
        int[][] arr2 = new int[N + 1][N + 1]; // 누적 합
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr1[i][j] = num;
                arr2[i][j] = num + arr2[i][j - 1] + arr2[i - 1][j] - arr2[i - 1][j - 1];
            }
        }
        // solve
        while (M > 0) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            if (w == 1) {
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                ans.append(arr2[y2][x2] - arr2[y1 - 1][x2] - arr2[y2][x1 - 1] + arr2[y1 - 1][x1 - 1]).append("\n");
            } else {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int num = c - arr1[y][x];
                for (int i = y; i <= N; i++) {
                    for (int j = x; j <= N; j++) {
                        arr2[i][j] += num;
                    }
                }
            }
            M--;
        }
        // output
        System.out.println(ans);
    }
}