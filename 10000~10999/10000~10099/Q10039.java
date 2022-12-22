import java.io.*;

public class Q10039 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            int score = Integer.parseInt(br.readLine());
            if (isFailed(score)) {
                answer += 40;
                continue;
            }
            answer += score;
        }
        System.out.println(answer / 5);
    }

    private static boolean isFailed(int score) {
        return score < 40;
    }
}