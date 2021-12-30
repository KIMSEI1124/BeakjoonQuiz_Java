import java.util.Scanner;

public class Q1009_ver2 {
    static Scanner sc = new Scanner(System.in);
    static final int testCaseCount = sc.nextInt();  // 테스트 케이스의 개수
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        for( int i = 0; i < testCaseCount; i++) {
            sb.append(String.valueOf(solve())+"\n");
        }
        System.out.print(sb);
    }
    
    public static int solve() {
        int computerNum = 1;
        int a = sc.nextInt();
        int b = sc.nextInt();
        for ( int i = 0; i < b; i++) {
            computerNum = (computerNum * a) % 10;
            if ( computerNum == 0) {
                computerNum = 10;
            }
        }
        return computerNum;
    }
}