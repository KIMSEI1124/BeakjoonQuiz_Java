import java.io.*;

public class Q11655 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int a = 'a';
        int A = 'A';
        int length = 'z' - 'a';
        char[] arr = br.readLine().toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (a <= arr[i] && arr[i] <= a + length) {
                arr[i] = shift(arr[i], a, length);
                continue;
            }
            if (A <= arr[i] && arr[i] <= A + length) {
                arr[i] = shift(arr[i], A, length);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            answer.append(arr[i]);
        }

        System.out.println(answer);
    }

    private static char shift(char target, int alpha, int length) {
        int temp = target + 13;
        if (temp > alpha + length) {
            temp = alpha + temp - (alpha + length + 1);
            return (char) temp;
        }
        return (char) temp;
    }
}