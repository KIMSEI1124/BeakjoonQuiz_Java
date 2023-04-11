import java.util.Scanner;

public class Q14681 {
    static Scanner sc = new Scanner(System.in);
    static int x, y;
    public static void main(String[] args){
        input();
        solve();
    }

    public static void input() {
        x = sc.nextInt();
        y = sc.nextInt();
    }

    public static void solve() {
        int answer;
        if ( x > 0 && y > 0 ) { // x와 y가 양수일 경우 ( 1사분면 )
            answer = 1;
        } else if ( x < 0 && y > 0 ) {  // x가 음수이고 y가 양수일 경우 ( 2사분면 )
            answer = 2;
        } else if ( x < 0 && y < 0 ) {  // x와 y가 음수일 경우 ( 3사분면 )
            answer = 3;
        } else {    // x가 양수이고 y가 음수일 경우 ( 4사분면 )
            answer = 4;
        }
        System.out.println(answer);
    }
}