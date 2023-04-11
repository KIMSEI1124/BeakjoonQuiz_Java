import java.io.*;
import java.util.*;

public class Q1940 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        // solve
        // int ans1 = solve1(N, M);
        int ans2 = solve2(N, M);
        // output
        // System.out.println(ans1);
        System.out.println(ans2);
    }

    // 두 포인터 사용 X
    // 9% 실패
    public static int solve1(int N, int M) throws IOException {
        // input
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        // solve
        for (int i = 0; i < list.size(); i++) {
            int num = M - list.get(i);
            if (list.contains(num)) {
                list.remove(i);
                ans++;
                i--;
            }
        }
        return ans;
    }

    // 두 포인터 사용
    public static int solve2(int N, int M) throws IOException {
        // input
        int ans = 0;
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // solve
        for (int i = 0; i < N; i++) { // start_point
            int target = M - arr[i];
            if (target != M && target > 0) {
                for (int j = arr.length - 1; j > i; j--) { // end_point
                    if (target == arr[j]) {
                        ans++;
                        arr[i] = 0;
                        arr[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}