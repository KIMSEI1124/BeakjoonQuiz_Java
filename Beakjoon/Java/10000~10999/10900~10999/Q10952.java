import java.util.*;

public class Q10952 {
    static Scanner sc = new Scanner(System.in);
    static int num1, num2;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        solve(sb);
        System.out.println(sb);
    }

    public static void input() {
        num1 = sc.nextInt();
        num2 = sc.nextInt();
    }

    public static StringBuilder solve(StringBuilder sb) {
        while (true) {
            input();
            if ( num1 == 0) {
                break;
            }
            sb.append(num1+num2+"\n");
        }
        return sb;
    }
}
