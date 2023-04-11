import java.util.*;

public class Q2742 {
    static Scanner sc = new Scanner(System.in);
    static int num = sc.nextInt();
    public static void main(String[] args){
        solve();
    }

    public static void solve() {
        StringBuilder sb = new StringBuilder();
        while(num != 0) {
            sb.append(num+"\n");
            num--;
        }
        System.out.println(sb);
    }
}