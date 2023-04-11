import java.io.*;

public class Q2523 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        getUpResult(N);
        getDownResult(N);
        System.out.println(answer);
    }

    private static void getUpResult(int N) {
        for (int i = 1; i <= N; i++) {
            appendAnswer(i);
        }
    }

    private static void getDownResult(int N) {
        for (int i = N - 1; i >= 1; i--) {
            appendAnswer(i);
        }
    }

    private static void appendAnswer(int i) {
        for (int j = 1; j <= i; j++) {
            answer.append("*");
        }
        answer.append("\n");
    }
}