import java.io.*;
import java.math.BigInteger;

public class Q2338 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BigInteger A = new BigInteger(br.readLine());
        BigInteger B = new BigInteger(br.readLine());
        answer.append(A.add(B)).append("\n")
                .append(A.subtract(B)).append("\n")
                .append(A.multiply(B));
        System.out.println(answer);
    }
}