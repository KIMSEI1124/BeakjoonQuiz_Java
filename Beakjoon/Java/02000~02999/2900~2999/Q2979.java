import java.io.*;
import java.util.*;

public class Q2979 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int answer = 0;
        int[] cost = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int loop = 3;
        int[] arr = new int[101];
        while (loop-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int i = start; i < end; i++) {
                arr[i]++;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 1) {
                answer += cost[0];
            } else if (arr[i] == 2) {
                answer += cost[1] * 2;
            } else if (arr[i] == 3) {
                answer += cost[2] * 3;
            }
        }

        System.out.println(answer);
    }
}
