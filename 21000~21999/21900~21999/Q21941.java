import java.io.*;
import java.util.*;

public class Q21941 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        int ans = 0;
        StringBuilder sb = new StringBuilder(br.readLine());
        int M = Integer.parseInt(br.readLine());
        // solve
        while (M > 0) {
            // 문자열 입력
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int x = Integer.parseInt(st.nextToken());

            // 원래 문자열 - 이후 문자열 = 사라진 문자의 개수

            M--;
        }
        ans += sb.length();
        // output
        System.out.println(ans);
    }
}