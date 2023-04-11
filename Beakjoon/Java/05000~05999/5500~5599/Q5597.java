import java.io.*;

public class Q5597 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        boolean[] check = new boolean[31];
        for (int i = 0; i < 28; i++) {
            check[Integer.parseInt(br.readLine())] = true;
        }
        for (int i = 1; i < check.length; i++) {
            if (!check[i]) {
                answer.append(i + "\n");
            }
        }
        System.out.println(answer);
    }
}