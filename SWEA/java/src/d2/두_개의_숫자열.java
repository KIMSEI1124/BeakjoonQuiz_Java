package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 두_개의_숫자열 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            int result = getResult();
            answer.append("#").append(testCase).append(" ").append(result).append("\n");
        }
        System.out.println(answer);
    }

    private static int getResult() throws IOException {
        int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); /* 0: N, 1: M */
        int[] a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] b = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (size[0] >= size[1]) {
            return solve(a, b);
        } else {
            return solve(b, a);
        }
    }

    private static int solve(int[] longArray, int[] shortArray) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= longArray.length - shortArray.length; i++) {
            int temp = 0;
            for (int j = 0; j < shortArray.length; j++) {
                temp += longArray[i + j] * shortArray[j];
            }
            max = Math.max(max, temp);
        }

        return max;
    }
}
