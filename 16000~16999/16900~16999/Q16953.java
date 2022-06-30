import java.io.*;
import java.util.*;

public class Q16953 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    static long A, B;

    public static void main(String[] args) throws IOException {
        // input
        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        int depth = 0;
        // solve
        bfs(A, depth);
        if (ans.length() == 0) {
            ans.append("-1");
        }
        // output
        System.out.println(ans);
    }

    static public void bfs(long num, int depth) {
        depth++;
        if (num == B) {
            ans.append(depth);
            return;
        } else if (num > B) {
            return;
        }
        bfs(mult(num), depth);
        bfs(add_one(num), depth);
    }

    static public long mult(long num) {
        return num *= 2;
    }

    static public long add_one(long num) {
        return num * 10 + 1;
    }
}