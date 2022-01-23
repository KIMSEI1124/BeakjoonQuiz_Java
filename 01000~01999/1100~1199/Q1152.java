import java.util.*;

public class Q1152 {    // 런타임 에러
    static Scanner sc = new Scanner(System.in);
    static String str = sc.nextLine();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        StringBuilder sb = new StringBuilder();
        String[] arr = str.split(" ");
        if (arr[0].equals("")) {
            sb.append((arr.length-1));
        } else {
            sb.append(arr.length);
        }
        System.out.println(sb);
    }
}