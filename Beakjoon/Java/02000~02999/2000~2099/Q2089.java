import java.io.*;
import java.util.*;

public class Q2089 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if (name.equals("#")) {
                break;
            }
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            answer.append(name).append(" ");
            if (age > 17 || weight >= 80) {
                answer.append("Senior");
            } else {
                answer.append("Junior");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}