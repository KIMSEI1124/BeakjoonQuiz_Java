import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q15829 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        BigInteger M = new BigInteger("1234567891");
        BigInteger bigHash = new BigInteger("0");
        char[] arr = br.readLine().toCharArray();
        for (int i = 0; i < L; i++) {
            BigInteger num = new BigInteger(String.valueOf(arr[i] - 96));
            bigHash = bigHash.add(num.multiply(ri(i)));
        }
        System.out.println(bigHash.remainder(M));
    }

    public static BigInteger ri(int i) {
        BigInteger r = new BigInteger("31");
        BigInteger ri = new BigInteger("1");
        for (int j = 0; j < i; j++) {
            ri = ri.multiply(r);
        }
        return ri;
    }
}