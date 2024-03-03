import java.io.*;
import java.util.*;

public class Q1018 {
    private static int answer = Integer.MAX_VALUE;

    private static int N;
    private static int M;
    private static boolean[][] grid;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                grid[i][j] = temp[j] == 'W';
            }
        }
    }

    private static void solve() {
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                answer = Math.min(check(i, j), answer);
            }
        }
    }

    private static int check(int y, int x) {
        boolean[][] map = copyMap(y, x);
        boolean isWhite = map[0][0];
        boolean isBlack = map[0][0];
        int whiteCount = 0;
        int blackCount = 0;
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (isWhite && c % 2 == 0 && map[r][c] == false) {
                    whiteCount++;
                } else if (isWhite && c % 2 == 1 && map[r][c]) {
                    whiteCount++;
                } else if (!isWhite && c % 2 == 0 && map[r][c]) {
                    whiteCount++;
                } else if (!isWhite && c % 2 == 1 && map[r][c] == false) {
                    whiteCount++;
                }
                if (isBlack && c % 2 == 0 && map[r][c]) {
                    blackCount++;
                } else if (isBlack && c % 2 == 1 && map[r][c] == false) {
                    blackCount++;
                } else if (!isBlack && c % 2 == 1 && map[r][c] == false) {
                    blackCount++;
                } else if (!isBlack && c % 2 == 0 && map[r][c]) {
                    blackCount++;
                }
            }
            isWhite = !isWhite;
            isBlack = !isBlack;
        }
        return Math.min(whiteCount, blackCount);
    }

    private static boolean[][] copyMap(int y, int x) {
        boolean[][] map = new boolean[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                map[i][j] = grid[i + y][j + x];
            }
        }
        return map;
    }
}