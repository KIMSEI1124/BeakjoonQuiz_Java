import java.io.*;
import java.util.*;

public class Q2869 {
    static int A, B, V;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
    }

    public static void solve() {
        int answer = (int) (Math.ceil((double) (V - A) / (A - B)) + 1);
        System.out.println(answer);
    }
}