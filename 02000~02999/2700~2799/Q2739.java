import java.util.*;

public class Q2739 {
    static Scanner sc = new Scanner(System.in);
    static int num = 0;
    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        num = sc.nextInt();
    }

    public static void solve() {
        for ( int i = 1; i < 10; i++) {
            System.out.println(num + " * " + i + " = " + num*i);
        }
    }
}
