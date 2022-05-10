import java.io.*;
import java.util.*;

public class Q1517 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        // solve
        int ans = solve2(N, st);
        // output
        System.out.println(ans);
    }

    public static int solve1(int N, StringTokenizer st) {
        int ans = 0;
        // 1-8, 1-7, 1-6, 1-5, 1-4, 1-3, 1-2 -> 8, 7번
        // 1-3, 1-2 -> 3, 2번
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int tmp;
        while (N > 1) {
            for (int i = 1; i < N; i++) {
                if (arr[i - 1] > arr[i]) {
                    tmp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = tmp;
                    ans++;
                }
            }
            N--;
        }
        return ans;
    }

    public static int solve2(int N, StringTokenizer st) {
        int ans = 0;
        int length;
        if (N % 2 == 0) {
            length = N / 2;
        } else {
            length = (N / 2) + 1;
        }
        System.out.println(length);
        int[] arr1 = new int[length];
        int[] arr2 = new int[length];
        int point_1 = 0;
        int point_2 = N / 2;
        for (int i = 0; i < N; i++) {
            if (i < N / 2) {
                arr1[i] = Integer.parseInt(st.nextToken());
            } else {
                arr2[i - (N / 2)] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        return ans;
    }
}