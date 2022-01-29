import java.util.Scanner;

public class Q2292 {
    static Scanner sc = new Scanner(System.in);
    static int num = sc.nextInt();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int answer = 1;
        int total = 1;
        while (total <= num) {
            total += 6*answer;
            answer++;
        }
        System.out.println(answer);
    }
}