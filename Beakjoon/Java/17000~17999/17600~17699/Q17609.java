import java.io.*;
import java.util.*;

public class Q17609 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    private static int t;
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(answer);
    }

    private static void input() throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            list.add(br.readLine());
        }
    }

    private static void solve() {
        for (int i = 0; i < t; i++) {
            String s = list.get(i);
            answer.append(getResult(s)).append("\n");
        }
    }

    private static String getResult(String s) {
        int head = 0;
        int tail = s.length() - 1;
        boolean flag = false;
        while (tail > head) {
            System.out.println(flag + " " + head + "" + s.charAt(head) + " " + tail + " " + s.charAt(tail));
            if (s.charAt(head) == s.charAt(tail)) { // 동일한 경우
                head++;
                tail--;
            } else if (flag == false && s.charAt(head) != s.charAt(tail)) { // 문자를 삭제하지 않고 동일하지 않은 경우
                flag = true;
                if (s.charAt(head) == s.charAt(tail - 1)) {
                    tail--;
                } else if (s.charAt(head + 1) == s.charAt(tail)) {
                    head++;
                } else { // 문자를 삭제해도 동일하지 않은 경우
                    return "2";
                }
            } else { // flag가 true 인 경우
                return "2";
            }
        }
        return flag == false ? "0" : "1";
    }
}