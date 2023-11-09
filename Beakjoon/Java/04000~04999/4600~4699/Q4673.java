import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Q4673 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arr[i] = i + 1;
            // solve에서 판별

            if (arr[i] != 0) {
                sb.append(arr[i] + "\n");
            }
        }
        System.out.println(sb);
    }

    public static void solve() {

    }
}