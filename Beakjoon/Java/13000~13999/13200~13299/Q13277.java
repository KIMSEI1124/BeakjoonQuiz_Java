import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Q13277 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String answer;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        BigInteger i1 = new BigInteger(st.nextToken());
        BigInteger i2 = new BigInteger(st.nextToken());
        answer =  i1.multiply(i2).toString();
        System.out.println(answer);
    }
}