import java.io.*;
import java.util.Arrays;

public class Q11721 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Arrays.stream(br.readLine().split("")).forEach(t -> {
            answer.append(t);
            if (answer.length() % 11 == 10) {
                answer.append("\n");
            }
        });
        System.out.println(answer);
    }
}