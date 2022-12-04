import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Q1271 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());
        answer.append(n.divide(m)).append("\n").append(n.remainder(m));
        System.out.println(answer);
    }
}