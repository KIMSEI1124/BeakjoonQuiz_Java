import java.util.*;

public class Q11399 {
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();

    public static void main(String[] args) {
        int[] p = new int[N];
        int answer = 0;
        int time = 0;
        for (int i = 0; i < N; i++) {
            p[i] = sc.nextInt();
        }
        Arrays.sort(p);
        for (int i = 0; i < N; i++) {
            time += p[i];
            answer += time;
        }
        System.out.println(answer);
    }
}