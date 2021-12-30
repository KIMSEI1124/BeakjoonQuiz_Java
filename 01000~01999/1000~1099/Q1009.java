import java.util.Scanner;

public class Q1009 {
    static Scanner sc = new Scanner(System.in);
    static final int testCaseCount = sc.nextInt();  // 테스트 케이스의 개수
    public static void main(String[] args) {
        for( int i = 0; i < testCaseCount; i++) {
            System.out.println(solve());
        }
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