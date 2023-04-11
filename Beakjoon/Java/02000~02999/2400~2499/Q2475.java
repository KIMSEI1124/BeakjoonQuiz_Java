import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        while (st.hasMoreTokens()) {
            answer += Math.pow(Double.parseDouble(st.nextToken()), 2);
        }
        answer %= 10;
        System.out.println(answer);
    }
}