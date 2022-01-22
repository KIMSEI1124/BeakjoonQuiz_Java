import java.util.*;

public class Q10998 {
    static Scanner sc = new Scanner(System.in);
    static int num1, num2;
    public static void main(String[] args){
        input();
        solve();
    }

    public static void input() {
        num1 = sc.nextInt();
        num2 = sc.nextInt();
    }

    public static void solve() {
        System.out.println(num1*num2);
    }
}
