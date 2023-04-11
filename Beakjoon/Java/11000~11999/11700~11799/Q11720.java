import java.util.Scanner;

public class Q11720 {
    static Scanner sc = new Scanner(System.in);
    static int A;
    static String[] N;
    public static void main(String[] args) {
        input();
        solve();
    }

    public static void input() {
        A = sc.nextInt();
        N = sc.next().split("");
    }

    public static void solve() {
        int answer = 0;
        for (int i = 0; i < A; i++) {
            answer += Integer.parseInt(N[i]);
        }
        System.out.println(answer);
    }
}