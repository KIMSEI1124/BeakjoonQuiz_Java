import java.io.*;

public class Q26545 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        while (N-- > 0) {
            answer += Long.valueOf(br.readLine());
        }
        System.out.println(answer);
    }
}