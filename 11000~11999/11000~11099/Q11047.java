import java.util.Scanner;

public class Q11047 {
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();
    static int K = sc.nextInt();

    public static void main(String[] args) {
        int[] arr = new int[N];
        input(arr);
        solve(arr);
    }

    public static int[] input(int[] arr) {
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void solve(int[] arr) {
        int answer = 0;
        while (N > 0 && K > 0) {
            int num = K / arr[N - 1];
            if (num > 0) {
                answer += num;
                K %= arr[N - 1];
            }
            N--;
        }
        System.out.println(answer);
    }
}