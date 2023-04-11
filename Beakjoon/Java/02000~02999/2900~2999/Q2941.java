import java.util.Scanner;

public class Q2941 {
    static Scanner sc = new Scanner(System.in);
    static String str = sc.next();
    static int answer = 1;

    public static void main(String[] args) {
        solve();
    }

    public static void endEqual(int i) {
        String sutStr = str.substring(i - 1, i);
        if (sutStr.equals("z")) {
            if (i >= 2) {
                sutStr = str.substring(i - 2, i);
                if (sutStr.equals("dz")) {
                    answer -= 1;
                }
            }
        }
        answer -= 1;
    }

    public static void endDash() {
        answer -= 1;
    }

    public static void endJ(int i) {
        String subStr = str.substring(i - 1, i);
        if (subStr.equals("l") || subStr.equals("n")) {
            answer -= 1;
        }
    }

    public static void solve() {
        for (int i = 1; i < str.length(); i++) {
            String subStr = str.substring(i, i + 1);
            if (subStr.equals("=")) {
                endEqual(i);
            } else if (subStr.equals("-")) {
                endDash();
            } else if (subStr.equals("j")) {
                endJ(i);
            }
            answer++;
        }
        System.out.println(answer);
    }
}