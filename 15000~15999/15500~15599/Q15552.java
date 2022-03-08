import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15552 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while (N > 0) {
            st = new StringTokenizer(br.readLine());
            int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            sb.append(sum).append("\n");
            N--;
        }
        System.out.println(sb);
    }
}