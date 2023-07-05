import java.io.*;

public class Q4999 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String a = br.readLine();
        String b = br.readLine();

        if (a.length() >= b.length()) {
            answer.append("go");
        } else {
            answer.append("no");
        }

        System.out.println(answer);
    }
}