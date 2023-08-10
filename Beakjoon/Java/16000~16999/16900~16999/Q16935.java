import java.io.*;
import java.util.*;

public class Q16935 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    private static int n, m, r; // 세로, 가로, 연산 횟수
    private static int[][] array;
    private static int[][] temp;
    private static int[] codes;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                answer.append(array[y][x]).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        /* 배열 입력 */
        array = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /* 연산 입력 */
        codes = new int[r];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            codes[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solve() {
        for (Integer code : codes) {
            if (code == 1) {
                upAndDownInversion();
            }
            if (code == 2) {
                leftAndRightInversion();
            }
            if (code == 3) {
                turnRight();
            }
            if (code == 4) {
                turnLeft();
            }
        }
    }

    /* 상하 반전 */
    private static void upAndDownInversion() {
        temp = new int[n][m];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                temp[n - 1 - y][x] = array[y][x];
            }
        }

        array = temp;
    }

    /* 좌우 반전 */
    private static void leftAndRightInversion() {
        temp = new int[n][m];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                temp[y][m - 1 - x] = array[y][x];
            }
        }

        array = temp;
    }

    /* 오른쪽 90도 회전 */
    private static void turnRight() {
        temp = new int[m][n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                temp[x][n - y - 1] = array[y][x];
            }
        }

        array = temp;
        n = array.length;
        m = array[0].length;
    }

    /* 왼쪽 90도 회전 */
    private static void turnLeft() {
        temp = new int[m][n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                temp[m - x - 1][y] = array[y][x];
            }
        }

        array = temp;
        n = array.length;
        m = array[0].length;
    }

    private static final int[] dy = { 0, 1, 0, -1 };
    private static final int[] dx = { 1, 0, -1, 0 };

    private static void clockwiseRotation() {
        int halfN = n / 2;
        int halfM = m / 2;
        for (int i = 0; i < 4; i++) {
            for (int y = 0; y < halfN; y++) {
                for (int x = 0; x < halfM; x++) {

                }
            }
        }
    }

    private static void counterClockwiseRotation() {

    }
}