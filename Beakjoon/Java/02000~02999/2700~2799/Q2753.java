import java.util.Scanner;

public class Q2753 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int year = sc.nextInt();
        if (year % 4 == 0) { // 4의 배수 이면서
            if (year % 100 != 0) { // 100의 배수가 아닐때
                System.out.println("1");
            } else if (year % 400 == 0) { // 400의 배수일때
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        } else {
            System.out.println("0");
        }
    }
}