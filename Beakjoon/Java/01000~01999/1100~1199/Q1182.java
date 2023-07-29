import java.io.*;
import java.util.*;

public class Q1182 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] array = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = array[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int target = array[j] - array[i];
                if (target == s) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    public static int func(int[] array, int idx1, int idx2) {
        int result = 0;
        return result;
    }
}