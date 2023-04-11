import java.util.*;

public class Q10950 {
    static Scanner sc = new Scanner(System.in);
    static int count = sc.nextInt();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int num1, num2;
        for (int i = 0; i < count; i++) {
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            System.out.println(num1 + num2);
        }
    }
}