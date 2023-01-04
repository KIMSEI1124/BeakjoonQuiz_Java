import java.io.*;
import java.util.*;

public class Q9093 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            addAnswer(br.readLine());
        }
        System.out.println(answer);
    }

    private static void addAnswer(String str) {
        st = new StringTokenizer(str);
        while(st.hasMoreTokens()) {
            StringBuilder temp = new StringBuilder(st.nextToken()).reverse();
            answer.append(temp + " ");
        }
        answer.append("\n");
    }
}   