import java.util.*;

public class Q11021 {
    static Scanner sc = new Scanner(System.in);
    static int count = sc.nextInt();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int num1, num2;
        for (int i = 1; i <= count; i++) {
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            System.out.println("Case #" + i + ": " + (num1 + num2));
        }
    }
}
