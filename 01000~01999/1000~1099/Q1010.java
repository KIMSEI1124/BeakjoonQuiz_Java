import java.util.Scanner;

public class Q1010 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static final int testCaseCount = sc.nextInt(); // 테스트 케이스의 개수

    public static void main(String[] args) {
        for (int i = 0; i < testCaseCount; i++) {
            sb.append(String.valueOf(solve()) + "\n");
        }
        System.out.println(sb);
    }

    public static int solve() {
        int answer = 0;
        int east_Point = sc.nextInt(); // 강 서쪽
        int west_Point = sc.nextInt(); // 강 동쪽
        for (int i = 0; i < 100; i++) {

        }
        return answer;
    }
}