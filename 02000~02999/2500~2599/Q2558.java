import java.util.Scanner;

public class Q2558 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        multiplication(num1, num2);
    }

    public static void multiplication(int num1, int num2) {
        int num3 = num1 * (num2 % 10); // 10으로 나눈 나머지를 구하면 일의 자리가 나온다.
        int num4 = num1 * ((num2 / 10) % 10); // 10으로 나눈 몫에 10으로 나눈 나머지를 구하면 십의 자리가 나온다.
        int num5 = num1 * (num2 / 100); // 100으로 나눈 몫을 구하면 백의 자리가 나온다.
        int num6 = num1 * num2;
        System.out.println(
            num3 + "\n" +
            num4 + "\n" + 
            num5 + "\n" + 
            num6);
    }
}
