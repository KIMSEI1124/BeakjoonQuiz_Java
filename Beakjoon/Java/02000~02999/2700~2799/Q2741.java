import java.util.*;

public class Q2741 {
    static Scanner sc = new Scanner(System.in);
    static int num;
    public static void main(String[] args){
        input();
        solve();
    }

    public static void input() {
        num = sc.nextInt();
    }

    public static void solve() {
        StringBuilder sb = new StringBuilder();
        for ( int i = 1; i <= num; i++) {
            sb.append(i+"\n");
        }
        System.out.println(sb);
    }
}