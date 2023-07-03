package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class 숫자_배열_회전 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            answer.append("#").append(testCase).append("\n");
            getResult();
        }
        System.out.println(answer);
    }

    private static void getResult() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] rotateArray90 = rotate(arr);
        int[][] rotateArray180 = rotate(rotateArray90);
        int[][] rotateArray270 = rotate(rotateArray180);

        for (int i = 0; i < arr.length; i++) {
            answer.append(toStringFromArray(rotateArray90[i]))
                    .append(" ")
                    .append(toStringFromArray(rotateArray180[i]))
                    .append(" ")
                    .append(toStringFromArray(rotateArray270[i]))
                    .append("\n");
        }
    }

    private static int[][] rotate(int[][] arr) {
        int length = arr.length;
        int[][] rotateArr = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                rotateArr[j][length - i - 1] = arr[i][j];
            }
        }
        return rotateArr;
    }

    private static String toStringFromArray(int[] arr) {
        return Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining());
    }
}
