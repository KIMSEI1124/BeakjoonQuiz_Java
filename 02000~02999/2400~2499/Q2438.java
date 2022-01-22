import java.util.*;

public class Q2438 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int star = sc.nextInt();
        solve(star);
    }

    public static void solve(int star) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= star; i++) {
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}