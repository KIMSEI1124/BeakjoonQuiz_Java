import java.io.*;
import java.util.*;

public class Q9019 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {
        // input
        T = Integer.parseInt(br.readLine());

        // solve
        while (T > 0) {
            st = new StringTokenizer(br.readLine());
            int start_register = Integer.parseInt(st.nextToken());
            int target_register = Integer.parseInt(st.nextToken());
            String op = "";
            bfs(start_register, target_register, op);
            T--;
        }

        // output
        System.out.println(ans);
    }

    static public void bfs(int now, int target, String op) {
        if(now == target) {
            ans.append("op");
        }
        
    }

    static public int D(int num) {
        return num * 2 % 10000;
    }

    static public int S(int num) {
        if (num == 0) {
            return 9999;
        }
        return num - 1;
    }

    static public int L(int num) {
        return num * 10 % 10000 + num / 1000;
    }

    static public int R(int num) {
        return num / 10 + (num % 10) * 1000;
    }
}