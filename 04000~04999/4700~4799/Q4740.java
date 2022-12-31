import java.io.*;
import java.util.StringTokenizer;

public class Q4740 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        System.out.println(str.length());
        // st = new StringTokenizer(br.readLine(), "\n");
        // while (st.hasMoreTokens()) {
        //     String str = st.nextToken();
        //     if (str.equals("***")) {
        //         break;
        //     }
        //     answer.append(reverse(str)).append("\n");
        // }
        // System.out.println(answer);
    }

    private static StringBuilder reverse(String str) throws IOException {
        StringBuilder sb = new StringBuilder(br.readLine());
        return sb;
    }
}