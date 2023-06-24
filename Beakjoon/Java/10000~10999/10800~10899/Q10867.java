import java.io.*;
import java.util.*;

public class Q10867 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).distinct().sorted().toArray();

        for (int i = 0; i < arr.length; i++) {
            answer.append(arr[i]).append(" ");
        }

        System.out.println(answer);
    }
}