import java.io.*;
import java.util.*;

public class Q1927 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder ans = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // input
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        // solve
        while (N > 0) {
            int x = Integer.parseInt(br.readLine()); // 중복값을 허용함
            if (x == 0) {
                if (list.isEmpty()) {
                    ans.append("0").append("\n");
                } else {
                    int min = Collections.min(list);
                    ans.append(min).append("\n");
                    list.remove(list.indexOf(min));
                }
            } else {
                list.add(x);
            }
            N--;
        }
        // output
        System.out.println(ans);
    }
}