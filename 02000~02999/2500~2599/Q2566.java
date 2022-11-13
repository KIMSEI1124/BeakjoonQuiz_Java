import java.io.*;
import java.util.*;

public class Q2566 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int maxValue = 0;
        int row = 0;
        int col = 0;

        for (int i = 1; i <= 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp >= maxValue) {
                    maxValue = temp;
                    row = i;
                    col = j;
                }
            }
        }
        answer.append(maxValue + "\n").append(row + " " + col);
        System.out.println(answer);
    }
}