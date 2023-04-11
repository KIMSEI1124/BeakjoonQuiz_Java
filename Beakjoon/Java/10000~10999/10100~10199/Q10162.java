import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10162 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        final int[] timer = { 300, 60, 10 };
        int[] count = { 0, 0, 0 };
        if (T % 10 != 0) {
            System.out.println("-1");
        } else {
            for (int i = 0; i < timer.length; i++) {
                if (T / timer[i] != 0) {
                    count[i] = T / timer[i];
                    T %= timer[i];
                }
            }
            System.out.println(count[0] + " " + count[1] + " " + count[2]);
        }
    }
}