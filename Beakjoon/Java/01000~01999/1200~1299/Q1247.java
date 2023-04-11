import java.io.*;
import java.math.BigInteger;

public class Q1247 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = 3;
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            BigInteger total = new BigInteger("0");
            while (N-- > 0) {
                total = total.add(new BigInteger(br.readLine()));
            }
            int flag = total.compareTo(new BigInteger("0"));
            if (flag > 0) {
                answer.append("+");
            } else if (flag < 0) {
                answer.append("-");
            } else if (flag == 0) {
                answer.append("0");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}