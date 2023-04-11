import java.util.Scanner;

public class Q2675 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testCase = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            solve(sb);

        }
        System.out.println(sb);
    }

    public static StringBuilder solve(StringBuilder sb) {
        int R = sc.nextInt();
        String[] arr = sc.next().split("");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < R; j++) {
                sb.append(arr[i]);
            }
        }
        sb.append("\n");
        return sb;
    }
}