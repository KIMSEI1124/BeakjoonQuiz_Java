import java.io.*;
import java.util.*;

public class Q2851 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // input
        int[] arr = new int[11];
        for (int i = 1; i <= 10; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(br.readLine());
        }
        // solve
        int length = 1000;
        int ans = 0;
        int num = 0;
        for (int i = 1; i <= 10; i++) {
            num = arr[i];
            if (num == 100) {
                ans = num;
                break;
            } else if (num < 100) {
                if (length > 100 - num) {
                    length = 100 - num;
                    ans = num;
                }
            } else {
                if (length >= num - 100) {
                    length = num - 100;
                    ans = num;
                }
            }
        }
        // output
        System.out.println(ans);
        //System.out.println(Arrays.toString(arr));
    }
}