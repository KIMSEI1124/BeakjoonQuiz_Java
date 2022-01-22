import java.util.*;

public class Q10871 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt(); // 정수 n개
        int x = sc.nextInt();
        solve(n, x);
    }

    public static void solve(int n, int x) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num < x) {
                sb.append(num + " ");
            }
        }
        System.out.println(sb);
    }
}