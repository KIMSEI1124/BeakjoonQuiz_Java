import java.util.*;

public class Q10951 {
    static Scanner sc = new Scanner("");
    static int num1, num2;

    public static void main(String[] args) {
        solve();
    }

    public static void input() {
        num1 = sc.nextInt();
        num2 = sc.nextInt();
    }

    public static void solve() {
        while (true) {
            try {
                if (sc.hasNext() == true) {
                    input();
                }
            } catch (NoSuchElementException e) {
                break;
            } finally {
                System.out.println(num1 + num2);
            }
        }
    }
}