import java.util.Scanner;

public class Q10872 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int N = sc.nextInt();
        int answer = 1;
        for(int i = N; 1 < i; i--) {
            answer *= i;
        }
        System.out.println(answer);
    } 
}