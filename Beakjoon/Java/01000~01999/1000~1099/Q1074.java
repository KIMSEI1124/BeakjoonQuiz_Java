import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1074 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer = 0;
    private static int n, r, c; // 배열의 크기 2^N * 2^N, r : 행, c : 열

    public static void main(String[] args) throws IOException {
        input();
        solve((int) Math.pow(2, n), r, c);
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
    }

    private static void solve(int size, int y, int x) {
        if (size == 1) {
            return;
        }

        int count = size * size / 4;
        int halfSize = size / 2;

        if (halfSize <= x && halfSize > y) { // 2사분면
            answer += count;
            solve(size / 2, y, x - size / 2);
        } else if (halfSize <= y && halfSize > x) { // 3사분면
            answer += count * 2;
            solve(size / 2, y - size / 2, x);
        } else if (halfSize <= x && halfSize <= y) { // 4사분면
            answer += count * 3;
            solve(size / 2, y - size / 2, x - size / 2);
        } else { // 1사분면
            solve(size / 2, y, x);
        }
    }
}
