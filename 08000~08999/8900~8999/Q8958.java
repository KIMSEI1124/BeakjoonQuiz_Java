import java.util.*;

public class Q8958 {
    static Scanner sc = new Scanner(System.in);
    static int testCase = sc.nextInt();
    static String str;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        for (int i = 0; i < testCase; i++) {
            input();
            solve();
        }
        System.out.println(sb);
    }

    public static void input() {
        str = sc.next();
    }

    public static void solve() {
        int chain = 0;
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals("O")) {
                chain++;
                answer += chain;
            } else {
                chain = 0;
            }
        }
        sb.append(answer + "\n");
    }
}