import java.io.*;
import java.util.*;

public class Q24725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
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
    }

    public static void find(String[][] arr, int i, int j) {
        // 4방향 탐색
        String[][] MBTI = new String[4][4];
        if(i >= 3 ) {
            int a = arr[0].length;
        }
    }

    public static void rightUp(String[][] arr, int i, int j) {
        String next;
        // i-, j+ (대각선 위)
        next = arr[i - 1][j + 1];
    }

    public static void right(String[][] arr, int i, int j) {
        String next;
        // -, j+ (오른쪽)
        next = arr[i][j + 1];
    }

    public static void rightDown(String[][] arr, int i, int j) {
        String next;
        // i+, j+ (대각선 아래)
        next = arr[i + 1][j + 1];
    }

    public static void down(String[][] arr, int i, int j) {
        String next;
        // i+, - (아래)
        next = arr[i + 1][j];
    }
}