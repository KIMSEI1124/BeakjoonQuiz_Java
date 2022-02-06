import java.util.*;

public class Q2577 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[3];
        input(arr);
        solve(arr);
    }

    public static int[] input(int[] arr) {
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void solve(int[] arr) {
        StringBuilder sb = new StringBuilder();
        String result = String.valueOf(arr[0] * arr[1] * arr[2]);
        int[] strArr = new int[10];
        for (int i = 0; i < result.length(); i++) {
            if (result.substring(i, i + 1).equals("0")) {
                strArr[0] += 1;
            } else if (result.substring(i, i + 1).equals("1")) {
                strArr[1] += 1;
            } else if (result.substring(i, i + 1).equals("2")) {
                strArr[2] += 1;
            } else if (result.substring(i, i + 1).equals("3")) {
                strArr[3] += 1;
            } else if (result.substring(i, i + 1).equals("4")) {
                strArr[4] += 1;
            } else if (result.substring(i, i + 1).equals("5")) {
                strArr[5] += 1;
            } else if (result.substring(i, i + 1).equals("6")) {
                strArr[6] += 1;
            } else if (result.substring(i, i + 1).equals("7")) {
                strArr[7] += 1;
            } else if (result.substring(i, i + 1).equals("8")) {
                strArr[8] += 1;
            } else if (result.substring(i, i + 1).equals("9")) {
                strArr[9] += 1;
            }
        }
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i] + "\n");
        }
        System.out.println(sb);
    }
}