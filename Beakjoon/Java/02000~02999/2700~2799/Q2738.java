import java.io.*;
import java.util.*;

public class Q2738 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] result = new int[N][M];
        result = addNumbers(result);
        result = addNumbers(result);
        
        getResultToStringBuilder(result);
        System.out.println(answer);
    }

    private static int[][] addNumbers(int[][] result) throws IOException {
        for (int i = 0; i < result.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] += Integer.parseInt(st.nextToken());
            }
        }
        return result;
    }

    private static void getResultToStringBuilder(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                answer.append(result[i][j] + " ");
            }
            answer.append("\n");
        }
    }
}