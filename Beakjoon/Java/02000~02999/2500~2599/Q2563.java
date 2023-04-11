import java.io.*;
import java.util.*;

public class Q2563 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer = 0;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine()); // 색종이의 개수
        int[][] drawingPaper = new int[100][100];
        while (N != 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int row = x; row < x + 10; row++) {
                for (int col = y; col < y + 10; col++) {
                    drawingPaper[row][col] = 1;
                }
            }
            N--;
        }
        for (int row = 0; row < drawingPaper.length; row++) {
            for (int col = 0; col < drawingPaper[row].length; col++) {
                if (drawingPaper[row][col] == 1) {
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }
}