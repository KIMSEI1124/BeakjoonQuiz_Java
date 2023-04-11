import java.io.*;
import java.util.*;

public class Q3003 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;
    private static int SIZE = 6;

    public static void main(String[] args) throws IOException {
        int[] defaultUnit = { 1, 1, 2, 2, 2, 8 };
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < SIZE; i++) {
            int unit = defaultUnit[i] - Integer.parseInt(st.nextToken());
            answer.append(String.valueOf(unit) + " ");
        }
        System.out.println(answer);
    }
}