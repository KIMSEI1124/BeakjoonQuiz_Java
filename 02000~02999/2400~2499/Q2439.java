import java.util.Scanner;

public class Q2439 {
    static Scanner sc = new Scanner(System.in);
    static int tree;

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        tree = sc.nextInt();
    }

    public static void solve() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= tree; i++) { // 줄과 별의 개수
            for (int j = 1; j <= tree; j++) {
                if (i + j > tree) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}