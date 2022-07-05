import java.io.*;
import java.util.*;

public class Q12759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans;
    static StringTokenizer st;
    static int start_player;
    static int[][] board = new int[4][4];

    public static void main(String[] args) throws IOException {
        // input
        ans = 0;
        start_player = Integer.parseInt(br.readLine());
        boolean turn_player = true; // true : 1번, false : 2번 플레이어

        // solve
        if (start_player == 2) { // 2번 플레이어부터 시작하면
            turn_player = false;
        }

        for (int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine());
            // 좌표 형식 (y,x)
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if (turn_player) { // 1번 플레이어
                board[y][x] = 1;
            } else { // 2번 플레이어
                board[y][x] = 2;
            }

            // Tic_Tac_Toe
            if (x + y == 4) { // 대각선 검사
                if (x == y) { // (1,1), (2,2), (3,3)
                    check(y_equals_x(), turn_player);
                    if (x == 2 && y == 2) { // (2,2)
                        check(y_not_equals_x(), turn_player);
                    }
                } else { // (1,3), (3,1)
                    check(y_not_equals_x(), turn_player);
                }
            }
            // 나머지
            check(y(y), turn_player);
            check(x(x), turn_player);

            if (ans != 0) {
                break;
            }

            if (turn_player) { // 플레이터 턴 바꾸기
                turn_player = false;
            } else {
                turn_player = true;
            }
        }

        // output
        System.out.println(ans);
    }

    static public boolean y(int y) { // 공통
        if (board[y][1] == board[y][2] && board[y][2] == board[y][3]) {
            return true;
        }
        return false;
    }

    static public boolean x(int x) { // 공통
        if (board[1][x] == board[2][x] && board[2][x] == board[3][x]) {
            return true;
        }
        return false;
    }

    static public boolean y_equals_x() { // (1,1), (2,2), (3,3)
        if (board[1][1] == board[2][2] && board[2][2] == board[3][3]) {
            return true;
        }
        return false;
    }

    static public boolean y_not_equals_x() { // (1,3), (2,2), (3,1)
        if (board[1][3] == board[2][2] && board[2][2] == board[3][1]) {
            return true;
        }
        return false;
    }

    static public void check(boolean is, boolean turn_player) {
        if (is == true) {
            if (turn_player == true) {
                ans = 1;
            } else {
                ans = 2;
            }
        }
    }
}