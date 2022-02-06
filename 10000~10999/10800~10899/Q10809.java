import java.util.Scanner;

public class Q10809 {
    static Scanner sc = new Scanner(System.in);
    static String str = sc.next();

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        for (int i = 0; i < str.length(); i++) {
            int num = Character.getNumericValue(str.charAt(i)) - 10;
            System.out.println(Character.getNumericValue(str.charAt(i)));
            if (arr[num] == -1) {
                arr[num] = i;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }
}