import java.util.Scanner;

public class Q10869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String quiz = sc.nextLine();
        String[] arr = quiz.split(" ");
        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[1]);
        System.out.println(num1+num2);
        System.out.println(num1-num2);
        System.out.println(num1*num2);
        System.out.println(num1/num2);
        System.out.println(num1%num2);
    }
}