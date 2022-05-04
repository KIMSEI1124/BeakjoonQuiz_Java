import java.io.*;

public class Q2018 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // input
        int N = Integer.parseInt(br.readLine());
        int ans = 1;
        // solve
        for (int i = 1; i <= N / 2; i++) { // start_point
            int sum = i;
            for (int j = i + 1; j <= N; j++) { // end_point
                if (sum >= N) {
                    if (sum == N) {
                        ans++;
                    }
                    break;
                } else if (sum < N) {
                    sum += j;
                }
            }
        }
        // output
        System.out.println(ans);
    }
}