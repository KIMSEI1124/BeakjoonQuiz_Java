import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Q15740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger aInt = new BigInteger(st.nextToken());
        BigInteger bInt = new BigInteger(st.nextToken());
        System.out.print(aInt.add(bInt));
    }
}