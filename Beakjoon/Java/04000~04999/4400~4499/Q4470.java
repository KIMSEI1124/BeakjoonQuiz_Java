import java.io.*;

public class Q4470 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            answer.append(i).append(". ").append(input).append("\n");
        }

        System.out.println(answer);
    }
}