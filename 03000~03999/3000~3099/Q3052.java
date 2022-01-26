import java.util.*;

public class Q3052 {
    static Scanner sc = new Scanner(System.in);
    static HashSet<Integer> hash = new HashSet<>();

    public static void main(String[] args) {
        solve();
    }

    public static int input(int num) {
        num = sc.nextInt();
        return num;
    }

    public static void solve() {
        int num = 0;
        for (int i = 0; i < 10; i++) {
            hash.add(input(num)%42);
        }
        System.out.println(hash.size());
    }
}