import java.io.*;
import java.util.*;

public class Q2420 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        long[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        long answer = arr[0] - arr[1];
        if (answer < 0) {
            answer *= -1;
        }

        System.out.println(answer);
    }
}