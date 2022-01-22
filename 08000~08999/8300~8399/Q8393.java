import java.util.*;

public class Q8393 {
    static Scanner sc = new Scanner(System.in);
    static int num = sc.nextInt();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int answer = 0;
        for (int i = 1; i <= num; i++) {
            answer += i;
        }
        System.out.println(answer);
    }
}