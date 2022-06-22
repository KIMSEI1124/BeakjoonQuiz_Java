import java.io.*;
import java.util.*;

public class Q24725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String[][] mbti = {
            { "E", "I" },
            { "N", "S" },
            { "F", "T" },
            { "P", "J" } };
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] arr = new String[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().split("");
        }
        for (int i = 0; i < N - 4; i++) {
            for (int j = 0; j < M - 4; j++) {

            }
        }
        System.out.println(answer);
    }

    public static void find(String[][] arr, int i, int j) {
        // 4방향 탐색

        try {
            
        } catch (Exception e) {

        }
    }

    public static String rightUp(String[][] arr, int i, int j) {
        // i-, j+ (대각선 위)
        String next = arr[i - 1][j + 1];
        return next;
    }

    public static String right(String[][] arr, int i, int j) {
        // -, j+ (오른쪽)
        String next = arr[i][j + 1];
        return next;
    }

    public static String rightDown(String[][] arr, int i, int j) {
        // i+, j+ (대각선 아래)
        String next = arr[i + 1][j + 1];
        return next;
    }

    public static String down(String[][] arr, int i, int j) {
        // i+, - (아래)
        String next = arr[i + 1][j];
        return next;
    }

    public static boolean check(String next, String[][] mbti, int run) {
        for (int i = 0; i < mbti[run].length; i++) {
            if (mbti[run].equals(next)) {
                return true;
            }
        }
        return false;
    }
}