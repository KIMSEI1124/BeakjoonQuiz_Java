import java.io.*;
import java.util.*;

public class Q16435 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer;
    private static StringTokenizer st;

    private static int n, l; // 과일의 개수, 초기 길이
    private static int[] fruits;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        fruits = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solve() {
        Arrays.sort(fruits);
        for (int i = 0; i < n; i++) {
            if (fruits[i] > l) {
                break;
            }
            l++;
        }
        answer = l;
    }
}