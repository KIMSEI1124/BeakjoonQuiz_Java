import java.io.*;

public class Q2440 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        while (N > 0) {
            for (int i = 0; i < N; i++) {
                answer.append("*");
            }
            answer.append("\n");
            N--;
        }
        System.out.println(answer);
    }
}