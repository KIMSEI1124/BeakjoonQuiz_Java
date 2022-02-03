import java.util.Scanner;

public class Q1931 {
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();

    public static void main(String[] args) {
        solve();
    }

    public static int input(int num) {
        num = sc.nextInt();
        return num;
    }

    public static void solve() {
        int start = 0;
        int end = 0;
        int num = 0;
        while (N > 0) {
            start = input(num);
            // if()
            System.out.println(start);
            N--;
        }
    }
}