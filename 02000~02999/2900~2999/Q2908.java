import java.util.Scanner;

public class Q2908 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    public static void main(String[] args) {
        input();
        int num1 = solve(sb1);
        int num2 = solve(sb2);
        System.out.println(Math.max(num1, num2));
    }

    public static void input() {
        sb1.append(sc.next());
        sb2.append(sc.next());
    }

    public static int solve(StringBuilder sb) {
        int num;
        String str;
        sb.reverse();
        str = String.valueOf(sb);
        num = Integer.parseInt(str);
        return num;
    }
}