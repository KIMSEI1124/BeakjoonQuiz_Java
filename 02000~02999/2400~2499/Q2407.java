import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Q2407 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        BigInteger ans = new BigInteger("1");

        // solve
        BigInteger new_BI;
        for (int i = N; i > 0; i--) {
            new_BI = new BigInteger(String.valueOf(i));
            if (i > N - M) {
                ans = ans.multiply(new_BI);
            } else if (M >= i) {
                ans = ans.divide(new_BI);
            }
        }

        // output
        System.out.println(ans);
    }
}