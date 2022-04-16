import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1016 {
    public static void main(String[] args) throws IOException {
        // Settings
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        int answer = 0;

        // input
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // solve - 1 소수 판별
        while (M > 0) {
            if (primeNum(M)) {
                System.out.println(M);
            }
            M--;
        }
    }

    public static boolean primeNum(int num) {
        if (num == 2) { // 2는 반드시 소수이다.
            return true;
        } else if (num % 2 == 0) { // 2로 나누어진 것들은 소수가 아니다.
            return false;
        } else if ((Math.sqrt(num) % 1) == 0) { // 제곱수가 있으면 소수가 아니다.
            return false;
        } else {
            return true;
        }
    }
}