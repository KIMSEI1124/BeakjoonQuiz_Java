import java.io.*;
import java.util.*;

public class Q2511 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int[] A = getArray();
        int[] B = getArray();
        char[] result = getResult(A, B);
        getAnswer(result);
        System.out.println(answer);
    }

    private static char[] getResult(int[] A, int[] B) {
        char[] result = new char[10];
        for (int i = 0; i < 10; i++) {
            int aCard = A[i];
            int bCard = B[i];
            if (canAWin(aCard, bCard)) {
                result[i] = 'A';
                continue;
            }
            if (canBWin(aCard, bCard)) {
                result[i] = 'B';
                continue;
            }
            result[i] = 'D';
        }
        return result;
    }

    private static int[] getArray() throws IOException {
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        return array;
    }

    private static boolean canAWin(int a, int b) {
        return a > b;
    }

    private static boolean canBWin(int a, int b) {
        return b > a;
    }

    private static void getAnswer(char[] result) {
        int a = 0;
        int b = 0;
        char win = 'D';
        for (int i = 0; i < result.length; i++) {
            char c = result[i];
            if (c != 'D') {
                win = c;
            }
            if (c == 'A') {
                a += 3;
            } else if (c == 'B') {
                b += 3;
            } else {
                a++;
                b++;
            }
        }
        answer.append(a + " " + b).append("\n");
        if (win != 'D' && a == b) {
            answer.append(win);
            return;
        }
        if (a > b) {
            answer.append("A");
        } else if (b > a) {
            answer.append("B");
        } else {
            answer.append("D");
        }
    }
}