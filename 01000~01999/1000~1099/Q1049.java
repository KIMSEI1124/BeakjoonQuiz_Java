import java.io.*;
import java.util.*;;

public class Q1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 구매 해야하는 기타줄의 수
        int M = Integer.parseInt(st.nextToken()); // 브랜드의 수
        var six = 1000; // 기타줄 패키지로 구매
        int one = 1000; // 기타줄 단품으로 구매
        int result = 0;

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            six = Math.min(six, Integer.parseInt(st.nextToken()));
            one = Math.min(one, Integer.parseInt(st.nextToken()));
        }

        /*
         * Solve
         * 단품 6개의 가격이 패키지보다 저렴하면 -> 단품으로 전부 구입
         * 패키지가 단품보다 저렴하면 -> 패키지로 전부 구입
         * 그 외 -> 패키지와 단품으로 구입
         */
        if (six > one * 6) {
            result = one * N;
        } else if (six / 6 < one) {
            result = N / 6 * six;
            if(N % 6 != 0) {
                result += six;
            }
        } else {
            result = ( N / 6 ) * six + N % 6 * one;
        }

        System.out.println(result);
    }
}