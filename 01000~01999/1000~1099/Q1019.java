import java.io.*;
import java.util.*;

public class Q1019 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10];
        int[] arr_10 = { 1, 2, 1, 1, 1, 1, 1, 1, 1, 1 };
        int[] arr_100 = { 11, 21, 20, 20, 20, 20, 20, 20, 20, 20 };
        int[] arr_1_000 = { 192, 301, 300, 300, 300, 300, 300, 300, 300, 300 };
        int[] arr_10_000 = { 2893, 4001, 4000, 4000, 4000, 4000, 4000, 4000, 4000, 4000 };
        int[] arr_100_000 = { 38894, 50001, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 };
        int[] arr_1_000_000 = { 488895, 600001, 600000, 600000, 600000, 600000, 600000, 600000, 600000 };
        int[] arr_10_000_000 = { 5888896, 7000001, 7000000, 7000000, 7000000, 7000000, 7000000, 7000000, 7000000,
                7000000 };
        int[] arr_100_000_000 = {6};
        // solve
        for (int i = 1; i <= N; i++) {
            String[] arr2 = String.valueOf(i).split("");
            int run = arr2.length - 1;
            while (run >= 0) {
                arr[Integer.parseInt(arr2[run])]++;
                run--;
            }
        }
        for (int i = 0; i < 10; i++) {
            ans.append(arr[i] + " ");
        }
        // output
        System.out.println(ans);
    }
}