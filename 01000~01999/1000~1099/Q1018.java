import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018 {
    public static void main(String[] args) throws IOException {
        // 보드판 세팅
        String[] B = { "B", "W", "B", "W", "B", "W", "B", "W" };
        String[] W = { "W", "B", "W", "B", "W", "B", "W", "B" };
        String[][] bBoard = { B, W, B, W, B, W, B, W };
        String[][] wBoard = { W, B, W, B, W, B, W, B };

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N과 M 변수 설정, 입력받은 보드판 세팅
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] board = new String[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().split("");
        }
        int min = 64; // 최소로 교환해야할 네모칸
        int bCheck;
        int wCheck;
        int xPos = 0, yPos = 0;
        for (int i = 0; i <= N - 8; i++) { // board판 y축
            for (int j = 0; j <= M - 8; j++) { // board판 x축
                bCheck = 0;
                wCheck = 0;
                for (int y = 0; y < 8; y++) { // board판 비교 y축
                    if (bCheck > min || wCheck > min) {
                        break;
                    }
                    for (int x = 0; x < 8; x++) { // board판 비교 x축
                        // System.out.println((y + i) + ", " + (x + j) + ", boardValue : " + board[y +
                        // i][x + j]
                        // + ", bBoardValue : " + bBoard[y][x] + ", wBoardValue : " + wBoard[y][x]);
                        if (!board[y + i][x + j].equals(bBoard[y][x])) {
                            bCheck += 1;
                        }
                        if (!board[y + i][x + j].equals(wBoard[y][x])) {
                            wCheck += 1;
                        }
                        if (x == 7 && y == 7) {
                            if (min > Math.min(wCheck, bCheck)) {
                                min = Math.min(wCheck, bCheck);
                                xPos = i;
                                yPos = j;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(min);
        System.out.println("xPos : " + xPos + ", yPos : " + yPos);
    }
}