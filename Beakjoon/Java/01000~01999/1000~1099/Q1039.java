import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q1039 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    /* 가독성 정보 */
    private static final int NOT_VISITED = 0;
    private static final char ZERO = '0';
    private static final int FIRST_INDEX = 0;

    /* 문제 정보 */
    private static final int[][] dp = new int[11][1_000_001]; // cnt : 연산 횟수, maxNumber : 최대 숫자
    private static int answer;
    private static String n;
    private static int k;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = st.nextToken();
        k = Integer.parseInt(st.nextToken());
    }

    private static void solve() {
        if (validateNumber()) {
            return;
        }
        answer = dfs(0, n);
    }

    /**
     * 한 자리 정수이거나<br />
     * `100` 미만의 정수 이고, 연산 횟수가 홀수이며, 정수를 10으로 나눈 나머지가 0인지 판단.
     *
     * @return 검증 결과 정상적이지 않은 숫자이면 `true`를 반환
     */
    private static boolean validateNumber() {
        int temp = Integer.parseInt(n);
        if (temp < 10 || (temp < 100 && temp % 10 == 0)) {
            answer = -1;
            return true;
        }
        return false;
    }

    /**
     * - 고민 1 : `String` 대신 `char[]` 을 사용하면 어떨까?<br />
     * 해당 문자열을 `int`와 `String`으로 변환해야하는 불편함 발생
     *
     * @param cnt    연산 횟수
     * @param number 교환 할 숫자
     */
    private static int dfs(int cnt, String number) {
        /* 이미 방문했다면 해당 값을 반환 합니다. */
        if (dp[cnt][Integer.parseInt(number)] != NOT_VISITED) {
            return dp[cnt][Integer.parseInt(number)];
        }

        /* 연산이 끝나면 해당 값을 반환합니다. */
        if (cnt == k) {
            return Integer.parseInt(number);
        }

        int maxNumber = Integer.MIN_VALUE;

        for (int i = 0; i < number.length(); i++) {
            for (int j = i + 1; j < number.length(); j++) {
                /* `0`이 맨 앞으로 올 수 없습니다. */
                if (i == FIRST_INDEX && number.charAt(j) == ZERO) {
                    continue;
                }
                maxNumber = Math.max(dfs(cnt + 1, swap(number, i, j)), maxNumber);
            }
        }

        dp[cnt][Integer.parseInt(number)] = maxNumber;
        return maxNumber;
    }

    private static String swap(String number, int i, int j) {
        char[] tempNumber = number.toCharArray();
        char temp = tempNumber[i];
        tempNumber[i] = tempNumber[j];
        tempNumber[j] = temp;
        return Stream.of(tempNumber).map(String::valueOf).collect(Collectors.joining());
    }
}
