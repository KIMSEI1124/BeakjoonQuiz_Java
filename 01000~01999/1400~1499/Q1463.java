import java.util.Scanner;

public class Q1463 {
    static Scanner sc = new Scanner(System.in);

    // 1로 만드는것은 되지만 최적의 경우는 아님
    public static void main(String[] args) {
        int X = sc.nextInt(); // 1 <= x <= 10^6
        int count = 0;
        while (1 < X) {
            if ( X % 3 == 0) {
                X /= 3;
            } else if ( X % 2 == 0) {
                X /= 2;
            } else {
                X--;
            }
            count++;
            System.out.println(X);
        }
        System.out.println(count);
    }
}