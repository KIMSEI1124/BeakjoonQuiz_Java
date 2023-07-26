import java.io.*;
import java.util.*;

public class Q11382 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        long answer = 0L;

        /* Input */
        StringTokenizer st = new StringTokenizer(br.readLine());

        /* Solve */
        while (st.hasMoreTokens()) {
            answer += Long.parseLong(st.nextToken());
        }

        System.out.println(answer);
    }
}