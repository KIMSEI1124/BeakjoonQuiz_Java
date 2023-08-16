import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1992 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();
    private static final int ERROR = -1;
    private static int n;
    private static int[][] grid;

    public static void main(String[] args) throws IOException {
        input();
        solve(n, 0, 0);
        System.out.println(answer);
    }

    private static void input() throws IOException {
        /* 배열 정보 입력 */
        n = Integer.parseInt(br.readLine());

        /* 배열 입력 */
        grid = new int[n][n];
        for (int y = 0; y < n; y++) {
            grid[y] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private static void solve(int size, int y, int x) {
        int number = getNumber(size, y, x);

        if (number == ERROR) {
            answer.append("(");
            solve(size / 2, y, x); // 1사분면
            solve(size / 2, y, x + size / 2); // 2사분면
            solve(size / 2, y + size / 2, x); // 3사분면
            solve(size / 2, y + size / 2, x + size / 2); // 4사분면
            answer.append(")");
            return;
        }

        answer.append(number);
    }

    private static int getNumber(int size, int y, int x) {
        int temp = grid[y][x];

        for (int i = y; i < size + y; i++) {
            for (int j = x; j < size + x; j++) {
                if (grid[i][j] != temp) {
                    return ERROR;
                }
            }
        }
        return temp;
    }
}
