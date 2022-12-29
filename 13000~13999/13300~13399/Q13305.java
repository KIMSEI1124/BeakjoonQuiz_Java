import java.io.*;
import java.util.*;

public class Q13305 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] degree = getArray();
        int[] gas = getArray();
        long[] price = new long[N - 1];
        long total = 0;
        for (int i = 0; i < N - 1; i++) {
            if (i == 0) {
                price[i] = gas[i];
                total += price[i] * degree[i];
                continue;
            }
            if (gas[i] > price[i - 1]) {
                price[i] = price[i - 1];
            } else {
                price[i] = gas[i];
            }
            total += price[i] * degree[i];
        }
        System.out.println(total);
    }

    private static int[] getArray() throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}