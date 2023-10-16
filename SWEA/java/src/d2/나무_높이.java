package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무_높이 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();

    private static int t;

    private static int n;
    private static int result;
    private static int max;
    private static int[] tree;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            input();
            solve();
            answer.append("#").append(i).append(" ").append(result).append("\n");
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        max = 0;
        result = 0;
        tree = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }
    }

    private static void solve() {
        int odd = 0;    // 짝수
        int even = 0;   // 홀수

        for (int i = 0; i < n; i++) {
            if (tree[i] == max) {   // 이미 최대로 자란 경우
                continue;
            }
            odd += (max - tree[i]) % 2;     // 2로 나눈 몫은 날짜의 갯수
            even += (max - tree[i]) / 2;    // 2로 나눈 나머지는 홀수 날짜의 갯수
        }

        int temp = Math.max(even - odd, 0) / 3;
        odd += temp * 2;
        even -= temp;
        int min = Math.min(odd, even);

        // 1과 2의 쌍으로 3의 배수를 만들 수 있다면 2일 연속 성장을 만들 수 있습니다.
        result = min * 2 + Math.max((odd - min) * 2 - 1, 0) + (even - min) / 2 * 3 + (even - min) % 2 * 2;
    }
}
