import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2775 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] arr = new int[15][14];
        int K; // 층
        int N; // 호
        while (T > 0) {
            K = Integer.parseInt(br.readLine());
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < K + 1; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == 0) {
                        arr[i][j] = j + 1;
                    } else {
                        
                    }
                }
            }
            T--;
        }
    }
}