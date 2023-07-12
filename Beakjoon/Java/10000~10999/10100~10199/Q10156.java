import java.io.*;
import java.util.*;

public class Q10156 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int ans = m - k * n;
        if (0 < ans) {
            ans = 0;
        } else {
            ans *= -1;
        }
        System.out.println(ans);
    }
}