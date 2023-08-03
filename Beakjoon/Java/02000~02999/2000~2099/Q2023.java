import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2023 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static int n;
    private static int[] PRIME_ARRAY = { 2, 3, 5, 7 };

    public static void main(String[] args) throws IOException {
        /* Input */
        n = Integer.parseInt(br.readLine());

        /* Solve */
        for (int i = 0; i < 4; i++) {
            isInterestingPrime(PRIME_ARRAY[i], 1);
        }

        System.out.println(answer);
    }

    private static void isInterestingPrime(int number, int depth) {
        if (depth > n || isPrime(number) == false) {
            return;
        }
        if (depth == n) {
            answer.append(number).append("\n");
            return;
        }
        for (int i = 0; i < 10; i++) {
            isInterestingPrime(number * 10 + i, depth + 1);
        }
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
