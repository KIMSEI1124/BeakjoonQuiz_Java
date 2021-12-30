import java.util.Scanner;

public class Q1008 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        double c = a/b;
        double d = a%b;
        System.out.println(c +" "+ d);
    }
}