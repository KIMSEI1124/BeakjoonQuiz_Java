package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 한빈이와_Spot_Mart {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    /* 전역 변수 */
    private static int t;       // 테스트 케이스 개수
    private static int n, m;    // 과자의 개수 / 무게 합 제한
    private static int[] array; // 과자의 무게

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            input();
            answer.append("#").append(testCase).append(" ").append(solve()).append("\n");
        }

        System.out.println(answer);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        /* 배열 정렬 */
        Arrays.sort(array);
    }

    private static int solve() {
        int max = -1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = array[i] + array[j];
                if (temp > m) {
                    break;
                }
                max = Math.max(max, temp);
            }
        }
        return max;
    }
}
