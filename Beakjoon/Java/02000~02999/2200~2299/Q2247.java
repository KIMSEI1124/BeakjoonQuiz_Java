import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2247 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    /* 입력 정보 */
    private static int n;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
    }

    private static void solve() {
        /* `N * N` 크기의 정사각형을 탐색 */
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                recursive(n, y, x);
            }
            answer.append("\n");
        }
    }

    private static void recursive(int size, int y, int x) {
        if (size == 1) {
            answer.append('*');
            return;
        }
        if (y / (size / 3) % 3 == 1 && x / (size / 3) % 3 == 1) {
            answer.append(' ');
            return;
        }
        recursive(size / 3, y, x);
    }
}
