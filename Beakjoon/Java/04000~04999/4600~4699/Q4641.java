import java.io.*;
import java.util.*;

public class Q4641 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();
    private static StringTokenizer st;
    private static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            input();
            if (set.contains(-1)) {
                break;
            }
            solve();
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        set = new HashSet<>();
        while (st.hasMoreTokens()) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        set.remove(0);
    }

    private static void solve() {
        int ret = 0;
        for (int number : set) {
            if (set.contains(number * 2)) {
                ret++;
            }
        }
        answer.append(ret).append("\n");
    }
}