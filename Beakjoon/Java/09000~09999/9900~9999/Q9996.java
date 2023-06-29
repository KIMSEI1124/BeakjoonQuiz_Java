import java.io.*;
import java.util.*;

public class Q9996 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), "*");
        String start = st.nextToken();
        String end = st.nextToken();

        while (n-- > 0) {
            String input = br.readLine();
            if (input.startsWith(start) && input.endsWith(end) && input.length() >= start.length() + end.length()) {
                answer.append("DA");
            } else {
                answer.append("NE");
            }
            answer.append("\n");
        }

        System.out.println(answer);
    }
}