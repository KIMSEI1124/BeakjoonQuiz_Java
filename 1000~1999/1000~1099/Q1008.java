import java.util.Scanner;

public class Q1008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        double c = a/b;
        double d = a%b;
        double e = c+d;
        System.out.println(c +" "+ d);
    }
}