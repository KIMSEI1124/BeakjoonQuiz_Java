import java.util.Scanner;

public class Q1341 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        String quiz = sc.nextLine();
        String[] arr = quiz.split(" ");
        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[1]);
        System.out.println(Comparison(num1,num2));
    }

    public static String Comparison(int a, int b){
        String answer = "";
        if ( a > b ) {
            answer = ">";
        } else if ( a < b ) {
            answer = "<";
        } else {
            answer = "==";
        }
        return answer;
    }
}