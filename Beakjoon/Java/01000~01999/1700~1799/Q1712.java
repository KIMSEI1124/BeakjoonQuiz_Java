import java.util.*;

public class Q1712 {
    static Scanner sc = new Scanner(System.in);
    static int A, B, C;

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
    }

    public static void solve() {
        if (B >= C) { // 손익분기점이 존재하지 않는 경우
            System.out.println("-1");
        } else {
            System.out.println((A / (C - B)) + 1);
        }
    }
}