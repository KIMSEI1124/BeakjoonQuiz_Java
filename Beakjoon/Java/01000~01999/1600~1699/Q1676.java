import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q1676 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
    }

    private static void solve() {
        BigInteger total = new BigInteger("1");
        for (int i = n; i > 0; i--) {
            total = total.multiply(new BigInteger(String.valueOf(i)));
            String str = total.toString();
            int temp = 0;
            for (int j = str.length() - 1; j >= 0; j--) {
                if (str.charAt(j) != '0') {
                    break;
                }
                temp++;
            }
            answer = Math.max(answer, temp);
        }
    }
}
