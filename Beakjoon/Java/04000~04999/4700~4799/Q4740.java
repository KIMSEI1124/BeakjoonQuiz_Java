import java.io.*;
import java.util.StringTokenizer;

public class Q4740 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while (true) {
            String str = br.readLine();
            if(str.equals("***")) {
                break;
            }
            answer.append(reverse(str)).append("\n");
        }
        System.out.println(answer);
    }

    private static StringBuilder reverse(String str) throws IOException {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse();
    }
}