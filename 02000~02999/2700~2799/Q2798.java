import java.util.Scanner;

public class Q2798 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j)
                    break;
                for (int k = 0; k < arr.length; k++) {
                    if (i == k || j == k)
                        break;
                    int score = arr[i] + arr[j] + arr[k];
                    if (score <= M && score > max)
                        max = score;
                }
            }
        }
        System.out.println(max);
    }
}