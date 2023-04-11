import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Q2407 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        BigInteger ans = new BigInteger("1");

        for (int i = 0; M > i; i++) {
            ans = ans
                    .multiply(new BigInteger(String.valueOf(N - i)))
                    .divide(new BigInteger(String.valueOf(i + 1)));
        }

        System.out.println(ans);
    }
}