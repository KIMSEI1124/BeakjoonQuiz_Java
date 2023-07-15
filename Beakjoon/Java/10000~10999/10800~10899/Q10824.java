import java.io.*;
import java.util.*;

public class Q10824 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        long ab = Long.valueOf(st.nextToken() + st.nextToken());
        long cd = Long.valueOf(st.nextToken() + st.nextToken());
        long answer = ab + cd;
        System.out.println(answer);
    }
}