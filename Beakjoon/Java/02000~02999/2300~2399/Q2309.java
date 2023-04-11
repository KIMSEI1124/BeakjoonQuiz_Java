import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2309 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        sum -= 100;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    arr[i] = arr[j] = 0;
                    break;
                }
            }
            if (arr[i] == 0) {
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                sb.append(arr[i] + "\n");
            }
        }
        System.out.println(sb);
    }
}