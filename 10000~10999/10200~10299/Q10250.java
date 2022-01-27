import java.util.Scanner;

public class Q10250 {
    static Scanner sc = new Scanner(System.in);
    static int H, W, N;

    public static void main(String[] args) {
        int testCase = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            input();
            solve(sb);
        }
        System.out.println(sb);
    }

    public static void input() {
        H = sc.nextInt();
        W = sc.nextInt();
        N = sc.nextInt();
    }

    public static void solve(StringBuilder sb) {
        sb.append(N % H); // 층 구하기
        if ((N / H) < 10) { // 호수 구하기
            sb.append("0" + ((N / H) + 1));
        } else {
            sb.append(N / H);
        }
        sb.append("\n");
    }
}