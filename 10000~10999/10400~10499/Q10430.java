import java.util.Scanner;

public class Q10430 {
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
        System.out.println((A + B) % C);
        System.out.println(((A % C) + (B % C)) % C);
        System.out.println((A * B) % C);
        System.out.println(((A % C) * (B % C)) % C);
    }
}
