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
        int answer = 0;
        while (true) {
            V -= A;
            answer++;
            if (V <= 0) {
                break;
            }
            V += B;
            System.out.println(answer);
        }
    }
}