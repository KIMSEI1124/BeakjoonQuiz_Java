import java.io.*;
import java.util.*;

public class Q3046 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int answer;

    private static int r1;
    private static int s;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
    }

    private static void solve() {
        answer = (s * 2) - r1;
    }
}