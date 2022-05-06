import java.io.*;
import java.util.*;

public class Q1253 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException { // 76퍼 실패
        // input
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>(); // key : number, value : count
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (hm.containsKey(arr[i])) {
                hm.replace(arr[i], hm.get(arr[i]) + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }
        br.close();
        // solve
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            int target = arr[i];
            i += hm.get(target) - 1; // 중복값 계산을 위한 수식
            int j = 0; // start_point
            int k = arr.length - 1; // end_point
            while (j < k) { // arr[0] ~ arr[i] 사이를 탐색
                // target을 탐색 수식에서 제외함
                if (j == i || k == i) {
                    if (j == i) {
                        j++;
                    } else if (k == i) {
                        k--;
                    }
                    if (j == k) {
                        break;
                    }
                }
                // 탐색 구간
                if (arr[j] + arr[k] == target) {
                    ans += hm.get(target);
                    break;
                } else if (arr[j] + arr[k] > target) {
                    k--;
                } else if (arr[j] + arr[k] < target) {
                    j++;
                }
            }
        }
        // output
        System.out.println(ans);
    }
}