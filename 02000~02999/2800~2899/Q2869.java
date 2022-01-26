import java.util.Scanner;

public class Q2869 {

    static Scanner sc = new Scanner(System.in);
    static int A, B, V;

    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        A = sc.nextInt();
        B = sc.nextInt();
        V = sc.nextInt();
    }

    public static void solve() {
        int answer = (int) (Math.ceil((double) (V - A) / (A - B)) + 1);
        System.out.println(answer);
    }
}