import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1239 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[st.countTokens()];
        for (int i = 0; i < N; i++) { // 세팅
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int startPoint = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {   // 0번 부터 탐색
            if (startPoint >= 50) { // 절반 이상을 넘어가면 종료
                break;
            }
            int percent = 0;
            for (int j = i; j < arr.length; j++) {
                percent += arr[j];
                if (percent == 50) {
                    count++;
                } else if (percent > 50) {
                    break;
                }
            }
            startPoint += arr[i];
        }
        System.out.println(count);
    }
}