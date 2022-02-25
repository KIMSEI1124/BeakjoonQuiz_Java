import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int max = Math.max(A, B);
        int min = Math.min(A, B);
        int gcd = gcd(max, min);
        int lcm = lcm(A, B, gcd);
        System.out.println(gcd+"\n"+lcm);
    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b, int gcd) {
        int aCoprime = a / gcd;
        int bCoprime = b / gcd;
        int lcm = aCoprime * bCoprime * gcd;
        return lcm;
    }
}