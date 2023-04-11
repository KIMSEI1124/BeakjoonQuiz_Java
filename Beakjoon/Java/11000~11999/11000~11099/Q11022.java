import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11022 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int a;
        int b;
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sum = a + b;
            sb.append("Case #").append(i).append(": ").append(a).append(" + ").append(b).append(" = ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}