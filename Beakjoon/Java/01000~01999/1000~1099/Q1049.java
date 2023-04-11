import java.io.*;
import java.util.*;;

public class Q1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int package_price = 1000;
        int one_price = 1000;
        int result;
        // 1
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            package_price = Math.min(package_price, Integer.parseInt(st.nextToken()));
            one_price = Math.min(one_price, Integer.parseInt(st.nextToken()));
        }

        // 2
        if(package_price <= one_price * (N % 6)) {
            result = N / 6 * package_price;
            if(N % 6 != 0) {
                result += package_price;
            }
        } else if (package_price > one_price * 6) {
            result = N * one_price;
        } else {
            result = N / 6 * package_price + N % 6 * one_price;
        }
        System.out.println(result);
    }
}