import java.io.*;
import java.util.*;

public class Q2752 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        for (int i : array) {
            answer.append(i).append(" ");
        }
        System.out.println(answer);
    }
}