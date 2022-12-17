import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Q15963 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        BigInteger N = new BigInteger(st.nextToken());
        BigInteger M = new BigInteger(st.nextToken());
        if (N.equals(M)) {
            System.out.println("1");
            return;
        }
        System.out.println("0");
    }
}