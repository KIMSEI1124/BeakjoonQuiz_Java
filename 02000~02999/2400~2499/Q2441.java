import java.io.*;

public class Q2441 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = N; i > 0; i--) {
            for (int j = 0; j < N - i; j++) {
                answer.append(" ");
            }
            for (int j = 0; j < i; j++) {
                answer.append("*");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}